package com.zhixing101.wechat.api.service.impl;

import com.zhixing101.wechat.api.dao.BookMapper;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adam on 10/9/16.
 */
@Service("bookService")
public class BookServiceImpl extends BasicService implements BookService {

    /**
     * slf4j 日志类
     **/
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    public boolean saveBook(Book book) {
        return bookMapper.saveBook(book);
    }

    public boolean updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    public boolean deleteBook(Book book) {
        return bookMapper.deleteBook(book);
    }

    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    public List<Book> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public List<Book> queryBooksByParams(String col, String val) {
        return bookMapper.queryBooksByParams(col,val);
    }
}
