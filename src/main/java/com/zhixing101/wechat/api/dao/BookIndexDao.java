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

import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.utils.BookDocumentUtils;
import com.zhixing101.wechat.api.utils.LuceneUtils;

@Repository("bookIndexDao")
public class BookIndexDao {

    @Autowired
    static BookMapper bookMapper;

    /**
     * 保存到索引库（建立索引）
     * 
     * @param book
     */
    public void save(Book book) {
        // 1，把Book转为Document
        Document doc = BookDocumentUtils.bookToDocument(book);

        // 2，添加到索引库中
        try {
            LuceneUtils.getIndexWriter().addDocument(doc); // 添加
            LuceneUtils.getIndexWriter().commit(); // 提交更改
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除索引
     * 
     * Term ：某字段中出现的某一个关键词（在索引库的目录中）
     * 
     * @param id
     */
    public void delete(Long id) {
        try {
            Term term = new Term("id", String.valueOf(id));

            LuceneUtils.getIndexWriter().deleteDocuments(term); // 删除所有含有这个Term的Document
            LuceneUtils.getIndexWriter().commit(); // 提交更改
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新索引
     * 
     * @param book
     */
    public void update(Book book) {
        try {
            Term term = new Term("id", String.valueOf(book.getId()));
            Document doc = BookDocumentUtils.bookToDocument(book);

            LuceneUtils.getIndexWriter().updateDocument(term, doc); // 更新就是先删除再添加
            LuceneUtils.getIndexWriter().commit(); // 提交更改
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getBookIdsByKeyword(String keyword, int pageSize, int pageIndex) {

        List<String> result = new ArrayList<String>();

        try {
            // start
            int start = pageSize * (pageIndex - 1);

            // count
            int count = start + pageSize;

            // Collector
            TopScoreDocCollector collector = TopScoreDocCollector.create(count);

            // Reader
            DirectoryReader reader = (DirectoryReader) LuceneUtils.getIndexReader();

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

            for (ScoreDoc scoreDoc : scoreDocs) {

                Document document = searcher.doc(scoreDoc.doc);
                String bookId = document.get("id");
                result.add(bookId);
            }

            return result;
        } catch (IOException e) {

            e.printStackTrace();
            return result;
        } catch (ParseException e) {

            e.printStackTrace();
            return result;
        }
    }

    /**
     * 根据关键词分页检索图书
     * 
     * @param keyword
     * @param pageSize
     * @param pageIndex
     */
    public List<Book> findBooksByKeyword(String keyword, int pageSize, int pageIndex) {

        List<Book> books = new ArrayList<Book>();
        List<String> bookIds = getBookIdsByKeyword(keyword, pageSize, pageIndex);
//        for (String bookId : bookIds) {
//            books.add(bookMapper.findBookById(Long.valueOf(bookId)));
//        }
        for (String bookId : bookIds) {
            Book book = new Book();
            book.setId(Long.valueOf(bookId));
            books.add(book);
        }
        return books;
    }
}
