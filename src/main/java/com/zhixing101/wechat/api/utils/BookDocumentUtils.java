package com.zhixing101.wechat.api.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

import com.zhixing101.wechat.api.entity.Book;

public class BookDocumentUtils {

    /**
     * 把Book转为Document
     * 
     * @param book
     * @return
     */
    public static Document articleToDocument(Book book) {

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
    public static Book documentToArticle(Document doc) {

        Book book = new Book();
        book.setId(Long.valueOf(doc.get("id")));

        return book;
    }
}
