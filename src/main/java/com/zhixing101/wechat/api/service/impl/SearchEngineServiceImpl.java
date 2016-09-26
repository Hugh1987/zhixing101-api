package com.zhixing101.wechat.api.service.impl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.SearchEngineService;

@Service("searchEngineService")
public class SearchEngineServiceImpl extends BasicService implements SearchEngineService {

    /**
     * slf4j 日志类
     **/
    private static final Logger logger = LoggerFactory.getLogger(SearchEngineServiceImpl.class);

    // indexPath
    String indexPath = "/tmp/zhixing101/luceneIndex";

    public List<String> getBookIdsByKeyword(String keyword, int pageSize, int pageIndex) {

        List<String> result = new ArrayList<String>();

        try {
            // start
            int start = pageSize * (pageIndex - 1);

            // count
            int count = start + pageSize;

            // Collector
            TopScoreDocCollector collector = TopScoreDocCollector.create(count);

            // Directory
            Directory dir = FSDirectory.open(Paths.get(indexPath));

            // Reader
            DirectoryReader reader = DirectoryReader.open(dir);

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

    public boolean addBookToIndex(Book book) {

        try {
            // Directory
            Directory dir = FSDirectory.open(Paths.get(indexPath));

            // Analyzer
            Analyzer analyzer = new SmartChineseAnalyzer();

            // IndexWriterConfig
            IndexWriterConfig conf = new IndexWriterConfig(analyzer);

            // IndexWriter
            IndexWriter writer = new IndexWriter(dir, conf);

            // Document
            Document doc = new Document();
            doc.add(new StringField("id", String.valueOf(book.getId()), Field.Store.YES));
            doc.add(new StringField("title", book.getTitle(), Field.Store.YES));
            doc.add(new StringField("version", book.getVersion(), Field.Store.YES));
            doc.add(new StringField("author", book.getAuthor(), Field.Store.YES));
            doc.add(new StringField("publisher", book.getPublisher(), Field.Store.YES));
            doc.add(new TextField("summary", book.getSummary(), Field.Store.YES));
            doc.add(new StringField("isbn10", book.getIsbn10(), Field.Store.YES));
            doc.add(new StringField("isbn13", book.getIsbn13(), Field.Store.YES));
            writer.addDocument(doc);

            writer.commit();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
