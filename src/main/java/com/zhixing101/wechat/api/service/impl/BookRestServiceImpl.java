package com.zhixing101.wechat.api.service.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BookService;
import com.zhixing101.wechat.api.utils.ISBNUtils;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by adam on 21/10/16.
 */
@Path("book")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("bookRestServiceImpl")
public class BookRestServiceImpl implements BookService {

    public boolean saveBook(Book book) {
        return false;
    }

    public boolean updateBook(Book book) {
        return false;
    }

    public boolean deleteBook(Book book) {
        return false;
    }

    public Book findBookById(Long id) {
        return null;
    }

    public Book findBookById(Integer id) {
        return null;
    }

    public List<Book> queryAllBooks() {
        return null;
    }

    public List<Book> queryBooksByParams(String col,String val) {
        return null;
    }

    @GET
    @Path("findBookByISBN/{isbn}")
    public Book findBookByISBN(@PathParam("isbn")String isbn) {
        return ISBNUtils.findBookByISBN(isbn);
    }

    public List<String> pagingQueryBooksByKeyword(String keyword, int pageSize, int pageIndex) {
        return null;
    }
}
