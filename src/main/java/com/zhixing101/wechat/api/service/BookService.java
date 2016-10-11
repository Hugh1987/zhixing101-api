package com.zhixing101.wechat.api.service;

import com.zhixing101.wechat.api.entity.Book;

import java.util.List;

/**
 * Created by adam on 10/9/16.
 */
public interface BookService {

    /**
     * 保存书籍信息
     * @param book
     * @return
     */
    boolean saveBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Book book);

    /**
     * 根据ID获取书籍信息
     * @param id
     * @return
     */
    Book findBookById(Long id);

    /**
     * 获取所有的书籍信息
     * @return
     */
    List<Book> queryAllBooks();

    /**
     * 根据参数查询书籍信息
     * @param col
     * @param val
     * @return
     */
    List<Book> queryBooksByParams(String col,String val);

    /**
     * 根据isbn返回Book对象
     * @param isbn
     * @return
     */
    Book findBookByISBN(String isbn);

    /**
     * 根据关键词返回Book对象
     * @param keyword
     * @param pageSize
     * @param pageIndex
     * @return
     */
    List<Book> pagingQueryBooksByKeyword(String keyword, int pageSize, int pageIndex);
}
