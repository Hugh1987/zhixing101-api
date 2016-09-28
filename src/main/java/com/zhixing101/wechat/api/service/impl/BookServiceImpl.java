package com.zhixing101.wechat.api.service.impl;

import com.zhixing101.wechat.api.dao.BookMapper;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.BookService;
import com.zhixing101.wechat.api.utils.ISBNUtils;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 10/9/16.
 */
@Service("bookServiceImpl")
public class BookServiceImpl extends BasicService implements BookService {

    /**
     * slf4j 日志类
     **/
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    // indexPath
    String indexPath = "/tmp/zhixing101/luceneIndex";

    public boolean saveBook(Book book) {
        boolean addDbResult = bookMapper.saveBook(book);
        boolean addIndexResult = addBookToIndex(book);
        return addDbResult && addIndexResult;
    }

    public boolean updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    public boolean deleteBook(Book book) {
        // return bookMapper.deleteBook(book);
        try {
            Process process = null;
            process = Runtime.getRuntime().exec("cd /usr/local");
            process.waitFor();
            Runtime.getRuntime().exec("./killapi.sh zhixing101_wechat_api");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    public Book findBookById(Long id) {
        return bookMapper.findBookById(id);
    }

    public List<Book> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public List<Book> queryBooksByParams(String col, String val) {
        return bookMapper.queryBooksByParams(col, val);
    }

    public Book findBookByISBN(String isbn) {
        // Book book = new Book();
        // book =ISBNUtils.findBookByISBN(isbn);
        // BookStoragePlace bookStoragePlace = new BookStoragePlace();
        // bookStoragePlace.setId(Long.parseLong(String.valueOf(1)));
        // Bookshelf bs = new Bookshelf();
        // bs.setId(Long.parseLong(String.valueOf(1)));
        // bs.setBookStoragePlace(bookStoragePlace);
        // book.setBookshelf(bs);
        // bookMapper.saveBook(book);
        return ISBNUtils.findBookByISBN(isbn);
    }

    public List<Book> findBooksByKerword(String keyword, int pageSize, int pageIndex) {

        List<Book> books = new ArrayList<Book>();
        List<String> bookIds = getBookIdsByKeyword(keyword, pageSize, pageIndex);
        for (String bookId : bookIds) {
            books.add(findBookById(Long.valueOf(bookId)));
        }
        return books;
    }

    private boolean addBookToIndex(Book book) {

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

            logger.info("start add book");
            logger.info("id : " + String.valueOf(book.getId()));
            logger.info("title : " + book.getTitle());
            logger.info("version : " + book.getVersion());
            logger.info("author : " + book.getAuthor());
            logger.info("isbn10 : " + book.getIsbn10());
            logger.info("isbn13 : " + book.getIsbn13());

            writer.addDocument(doc);

            writer.commit();
            writer.close();

            logger.info("add book succeed");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("add book failed");
            return false;
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

}
