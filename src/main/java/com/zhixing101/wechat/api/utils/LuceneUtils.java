package com.zhixing101.wechat.api.utils;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuceneUtils {

    // 日志记录器
    private static final Logger logger = LoggerFactory.getLogger(LuceneUtils.class);

    // lucene索引存储路径
    private static String indexPath = "/usr/local/zhixing101/luceneIndex";
    // 索引目录
    private static Directory directory;
    // 分词器
    private static Analyzer analyzer;
    // IndexWriterConfig
    private static IndexWriterConfig indexWriterConfig;
    // IndexWriter
    private static IndexWriter indexWriter;
    // IndexReader
    private static IndexReader indexReader;

    static {

        try {
            // 初始化索引目录
            directory = FSDirectory.open(Paths.get(indexPath));
            // 初始化分词器
            analyzer = new SmartChineseAnalyzer();
            logger.info("LuceneUtils初始化成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取全局唯一的IndexReader对象
     * 
     * @return
     */
    public static IndexReader getIndexReader() {
        // 在第一次使用IndexReader时进行初始化
        if (indexReader == null) {
            // 线程安全
            synchronized (LuceneUtils.class) {
                if (indexReader == null) {
                    try {
                        indexReader = DirectoryReader.open(directory);
                        logger.info("IndexReader初始化成功");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // 在JVM退出前执行下面的代码
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        indexReader.close();
                        logger.info("IndexReader已关闭");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return indexReader;
    }

    /**
     * 获取全局唯一的IndexWriter对象
     * 
     * @return
     */
    public static IndexWriter getIndexWriter() {
        // 在第一次使用IndexWriter时进行初始化
        if (indexWriter == null) {
            // 线程安全
            synchronized (LuceneUtils.class) {
                if (indexWriter == null) {
                    try {
                        indexWriterConfig = new IndexWriterConfig(analyzer);
                        indexWriter = new IndexWriter(directory, indexWriterConfig);
                        logger.info("IndexWriter初始化成功");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // 在JVM退出前执行下面的代码
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        indexWriter.close();
                        logger.info("IndexWriter已关闭");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        return indexWriter;
    }

    public static Directory getDirectory() {
        return directory;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }
}
