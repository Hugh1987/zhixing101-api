package com.zhixing101.wechat.api.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.common.Constant;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 26/10/16.
 */
@Component("luceneIndexUtils")
public class LuceneIndexUtils {

    private static final Logger logger = LoggerFactory.getLogger(LuceneIndexUtils.class);

    /**
     * 保存到索引库（建立索引）
     *
     * @param document
     */
    public void save(Document document) throws Exception {

        logger.debug("BookIndexDao.save begin");

        // 添加到索引库中
        LuceneUtils.getIndexWriter().addDocument(document);
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
    public void update(String id, Document document) throws Exception {

        logger.debug("BookIndexDao.update begin");

        Term term = new Term("id", id);

        // 更新就是先删除再添加
        LuceneUtils.getIndexWriter().updateDocument(term, document);
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
            DirectoryReader reader = (DirectoryReader) LuceneUtils.getIndexReader();

            // IndexSearcher
            IndexSearcher searcher = new IndexSearcher(reader);

            // Analyzer
            Analyzer analyzer = new SmartChineseAnalyzer();

            // Query
            Query query = new MultiFieldQueryParser(Constant.BOOK_FIELDS, analyzer).parse(keyword);

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

        List<String> bookIds = getBookIdsByKeyword(keyword, pageSize, pageIndex);

        logger.debug("BookIndexDao.findBooksByKeyword end");
        return bookIds;
    }
}
