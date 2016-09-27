package com.zhixing101.wechat.api.service.impl;

import com.zhixing101.wechat.api.service.BookService;
import com.zhixing101.wechat.api.utils.ISBNUtils;
import junit.Junit4BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by adam on 10/9/16.
 */
public class BookServiceImplTest extends Junit4BaseTest {

//    private static final Logger logger = LoggerFactory.getLogger(BookServiceImplTest.class);
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BookServiceImplTest.class);

    @Autowired
    BookService bookService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Ignore
    public void testSaveBook() throws Exception {

    }

    @Test
    @Ignore
    public void testQueryAllBooks() throws Exception {
//        List<Book> bookList = bookService.queryAllBooks();
//        logger.debug("there are " + bookList.size() + " books");
//        for (Book book : bookList){
//            logger.debug("this is book" + book.getAuthor());
//        }
        logger.debug("test");
        System.out.println("1231231123");
    }

    @Test
    public void testFindBookByISBN(){
        try {
            ISBNUtils.findBookByISBN("9787539989891");
            bookService.findBookByISBN("9787539989891");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
