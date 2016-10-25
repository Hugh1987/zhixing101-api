package com.zhixing101.wechat.api.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.utils.BookDocumentUtils;
import com.zhixing101.wechat.api.utils.LuceneUtils;

@Repository("bookIndexDao")
public class BookIndexDao {

    private static final Logger logger = LoggerFactory.getLogger(BookIndexDao.class);

    @Autowired
    static BookMapper bookMapper;

    /**
     * 保存到索引库（建立索引）
     * 
     * @param book
     */
    public void save(Book book) throws Exception {

        logger.debug("BookIndexDao.save begin");
        logger.debug("Book to handle : " + book);

        // 把Book转为Document
        Document doc = BookDocumentUtils.bookToDocument(book);
        // 添加到索引库中
        LuceneUtils.getIndexWriter().addDocument(doc);
        // 提交更改
        LuceneUtils.getIndexWriter().commit();

        logger.debug("BookIndexDao.save end");
    }

    /**
     * 删除索引
     * 
     * Term ：某字段中出现的某一个关键词（在索引库的目录中）
     * 
     * @param id
     */
    public void delete(Long id) throws Exception {

        logger.debug("BookIndexDao.delete begin");
        logger.debug("BookId : " + id + "to delete.");

        Term term = new Term("id", String.valueOf(id));
        // 删除所有含有这个Term的Document
        LuceneUtils.getIndexWriter().deleteDocuments(term);
        // 提交更改
        LuceneUtils.getIndexWriter().commit();

        logger.debug("BookIndexDao.delete end");
    }

    /**
     * 更新索引
     * 
     * @param book
     * @throws IOException
     */
    public void update(Book book) throws Exception {

        logger.debug("BookIndexDao.update begin");
        logger.debug("Book to handle : " + book);

        Term term = new Term("id", String.valueOf(book.getId()));
        Document doc = BookDocumentUtils.bookToDocument(book);
        // 更新就是先删除再添加
        LuceneUtils.getIndexWriter().updateDocument(term, doc);
        // 提交更改
        LuceneUtils.getIndexWriter().commit();

        logger.debug("BookIndexDao.update begin");
    }

    private List<String> getBookIdsByKeyword(String keyword, int pageSize, int pageIndex) {

        logger.debug("BookIndexDao.getBookIdsByKeyword begin");
        logger.debug("keyword = " + keyword + ", pageSize = " + pageSize + ", pageIndex = " + pageIndex);

        List<String> result = new ArrayList<String>();

        try {
            // start
            int start = pageSize * (pageIndex - 1);

            // count
            int count = start + pageSize;

            // Collector
            TopScoreDocCollector collector = TopScoreDocCollector.create(count);

            // Reader
            DirectoryReader oldReader = (DirectoryReader) LuceneUtils.getIndexReader();
            DirectoryReader reader = DirectoryReader.openIfChanged(oldReader);

            // IndexSearcher
            IndexSearcher searcher = new IndexSearcher(reader);

            // Analyzer
            Analyzer analyzer = new SmartChineseAnalyzer();

            // MultiField
            String[] fields = { "id", "title", "version", "author", "publisher", "summary", "isbn10", "isbn13" };

            // Query
            Query query = new MultiFieldQueryParser(fields, analyzer).parse(keyword);

            // doSearch
            searcher.search(query, collector);

            // TopDocs
            TopDocs topDocs = collector.topDocs(start, pageSize);

            // scoreDocs
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            logger.debug("scoreDocs.length = " + String.valueOf(scoreDocs.length));

            for (ScoreDoc scoreDoc : scoreDocs) {

                Document document = searcher.doc(scoreDoc.doc);
                String bookId = document.get("id");
                result.add(bookId);
            }

            return result;

        } catch (IOException e) {

            e.printStackTrace();
        } catch (ParseException e) {

            e.printStackTrace();
        }

        logger.debug("BookIndexDao.getBookIdsByKeyword end");

        return result;
    }

    /**
     * 根据关键词分页检索图书
     * 
     * @param keyword
     * @param pageSize
     * @param pageIndex
     */
    public List<String> findBooksByKeyword(String keyword, int pageSize, int pageIndex) {

        logger.debug("BookIndexDao.findBooksByKeyword start");

        List<Book> books = new ArrayList<Book>();
        List<String> bookIds = getBookIdsByKeyword(keyword, pageSize, pageIndex);
        // for (String bookId : bookIds) {
        // books.add(bookMapper.findBookById(Long.valueOf(bookId)));
        // }

        logger.debug("BookIndexDao.findBooksByKeyword end");
        return bookIds;
    }
}
