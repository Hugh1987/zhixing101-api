package com.zhixing101.wechat.api.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhixing101.wechat.api.dao.BookMapper;
import com.zhixing101.wechat.api.entity.Book;

public class BookDocumentUtils {

    @Autowired
    static BookMapper bookMapper;

    /**
     * 把Book转为Document
     * 
     * @param book
     * @return
     */
    public static Document bookToDocument(Book book) {

        Document doc = new Document();
        doc.add(new StringField("id", String.valueOf(book.getId()), Field.Store.YES));
        doc.add(new TextField("author", book.getAuthor(), Field.Store.YES));
        doc.add(new TextField("summary", book.getSummary(), Field.Store.YES));
        doc.add(new TextField("title", book.getTitle(), Field.Store.YES));
        doc.add(new TextField("publisher", book.getPublisher(), Field.Store.YES));
        doc.add(new TextField("version", book.getVersion(), Field.Store.YES));

        return doc;
    }

    /**
     * 把Document转为Book
     * 
     * @param doc
     * @return
     */
    public static Book documentToBook(Document doc) {

        return bookMapper.findBookById(Long.valueOf(doc.get("id")));
    }
}
