package com.zhixing101.wechat.api.dao;

import com.zhixing101.wechat.api.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adam on 10/9/16.
 */
@Repository("bookMapper")
public interface BookMapper {

    /**
     * 保存书籍信息
     * @param book
     * @return
     */
    boolean saveBook(@Param("book") Book book);

    boolean updateBook(@Param("book") Book book);

    boolean deleteBook(@Param("book") Book book);

    /**
     * 根据ID获取书籍信息
     * @param id
     * @return
     */
    Book findBookById(@Param("id") Long id);

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
    List<Book> queryBooksByParams(@Param("col") String col,@Param("val") String val);

}
