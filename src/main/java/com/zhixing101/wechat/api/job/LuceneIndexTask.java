package com.zhixing101.wechat.api.job;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.entity.Book;
import com.zhixing101.wechat.api.service.BookService;
import com.zhixing101.wechat.api.utils.BookDocumentUtils;
import com.zhixing101.wechat.api.utils.LuceneIndexUtils;
import org.apache.lucene.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;

/**
 * 每日定时刷新索引
 * Created by adam on 24/10/16.
 */
public class LuceneIndexTask {

    private static final Logger logger = LoggerFactory.getLogger(LuceneIndexTask.class);

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    BookService bookService;

    @Autowired
    LuceneIndexUtils luceneIndexUtils;

    /**
     * 1.首先获取所有的增量数据
     * 2.对比是否存在于索引中
     */
    public void executeTask() throws InterruptedException{
        CheckLuceneIndex checkLuceneIndex = new CheckLuceneIndex();
        checkLuceneIndex.run();
    }

    class CheckLuceneIndex implements Runnable{

        public void run() {
            logger.debug("begin lucene index task");
            List<Book> bookList = bookService.queryAllBooks();
            for (Book book : bookList){
                List<String> result = luceneIndexUtils.findBooksByKeyword(String.valueOf(book.getId()),1,10);
                if (result.size() < 1){
                    Document document = BookDocumentUtils.bookToDocument(book);
                    try {
                        luceneIndexUtils.save(document);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}
