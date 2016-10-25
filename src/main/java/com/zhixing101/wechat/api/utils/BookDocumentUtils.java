package com.zhixing101.wechat.api.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.dao.BookMapper;
import com.zhixing101.wechat.api.entity.Book;

public class BookDocumentUtils {

    private static final Logger logger = LoggerFactory.getLogger(BookDocumentUtils.class);

    @Autowired
    static BookMapper bookMapper;

    /**
     * 把Book转为Document
     *
     * @param book
     * @return
     */
    public static Document bookToDocument(Book book) {

        logger.debug("BookDocumentUtils.bookToDocument begin");
        logger.debug("Convert" + book + "to Document");

        Document doc = new Document();
        doc.add(new StringField("id", String.valueOf(book.getId()), Field.Store.YES));
        doc.add(new TextField("author", book.getAuthor(), Field.Store.YES));
        doc.add(new TextField("summary", book.getSummary(), Field.Store.YES));
        doc.add(new TextField("title", book.getTitle(), Field.Store.YES));
        doc.add(new TextField("publisher", book.getPublisher(), Field.Store.YES));
        doc.add(new TextField("version", book.getVersion(), Field.Store.YES));
        doc.add(new TextField("isbn10", book.getIsbn10(), Field.Store.YES));
        doc.add(new TextField("isbn13", book.getIsbn13(), Field.Store.YES));

        logger.debug("BookDocumentUtils.bookToDocument end");

        return doc;
    }

    /**
     * 把Document转为Book
     *
     * @param doc
     * @return
     */
    public static Book documentToBook(Document doc) {

        logger.debug("BookDocumentUtils.documentToBook begin");
        logger.debug("Convert Document to Book, book id = " + doc.get("id"));
        logger.debug("BookDocumentUtils.documentToBook end");

        return bookMapper.findBookById(Long.valueOf(doc.get("id")));
    }
}
