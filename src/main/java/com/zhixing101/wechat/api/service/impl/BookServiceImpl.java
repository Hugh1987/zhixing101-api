package com.zhixing101.wechat.api.service.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.dao.BookIndexDao;
import com.zhixing101.wechat.api.dao.BookMapper;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.BookService;
import com.zhixing101.wechat.api.utils.BookDocumentUtils;
import com.zhixing101.wechat.api.utils.ISBNUtils;
import com.zhixing101.wechat.api.utils.LuceneIndexUtils;
import org.apache.lucene.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adam on 10/9/16.
 */
@Service("bookServiceImpl")
public class BookServiceImpl extends BasicService implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookIndexDao bookIndexDao;

    @Autowired
    LuceneIndexUtils luceneIndexUtils;

    public boolean saveBook(Book book) {

        logger.debug("BookServiceImpl#saveBook begin");
        logger.debug("Book to handle : " + book);

        // 处理成功flag初始化为false
        boolean successFlag = false;

        // 根据book对象的isbn13字段搜索数据库
        List<Book> bookList = bookMapper.queryBooksByParams("isbn13", book.getIsbn13());

        // 数据库中不存在该isbn13对应的book对象
        if (bookList.size() < 1) {

            logger.debug("This book does not exist in database.Start to add this book into database and lucene.");

            try {
                // 保存book对象到数据库中
                bookMapper.saveBook(book);
                // 保存book对象到lucene索引中
                // 把Book转为Document
                Document doc = BookDocumentUtils.bookToDocument(book);
                luceneIndexUtils.save(doc);
//                bookIndexDao.save(book);
                // 处理成功
                successFlag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.debug("This book exists in database.Do nothing with this book.");
        }

        logger.debug("BookServiceImpl#saveBook successFlag : " + successFlag);
        logger.debug("BookServiceImpl#saveBook end");

        return successFlag;
    }

    public boolean updateBook(Book book) {

        logger.debug("BookServiceImpl#updateBook begin");
        logger.debug("Book to handle : " + book);

        // 处理成功flag初始化为false
        boolean successFlag = false;

        try {
            // 更新数据库中的book对象
            bookMapper.updateBook(book);
            // 更新lucene索引中的book对象
            bookIndexDao.update(book);
            // 处理成功
            successFlag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.debug("BookServiceImpl#updateBook successFlag : " + successFlag);
        logger.debug("BookServiceImpl#updateBook end");

        return successFlag;
    }

    public boolean deleteBook(Book book) {

        logger.debug("BookServiceImpl#deleteBook begin");
        logger.debug("Book to handle : " + book);

        // 处理成功flag初始化为false
        boolean successFlag = false;

        try {
            // 删除数据库中的book对象
            bookMapper.deleteBook(book);
            // 删除lucene索引中的book对象
            bookIndexDao.delete(book.getId());
            // 处理成功
            successFlag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.debug("BookServiceImpl#deleteBook successFlag : " + successFlag);
        logger.debug("BookServiceImpl#deleteBook end");

        return successFlag;
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
        return ISBNUtils.findBookByISBN(isbn);
    }

    public List<String> pagingQueryBooksByKeyword(String keyword, int pageSize, int pageIndex) {

        logger.debug("BookServiceImpl#pagingQueryBooksByKeyword start");
        logger.debug("keyword = " + keyword + ", pageSize = " + pageSize + ", pageIndex = " + pageIndex);

        return bookIndexDao.findBooksByKeyword(keyword, pageSize, pageIndex);
    }
}
