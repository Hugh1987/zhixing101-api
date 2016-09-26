package com.zhixing101.wechat.api.service;

import java.util.List;

import com.zhixing101.wechat.api.entity.Book;

/**
 * 搜索引擎服务
 */
public interface SearchEngineService {

    /**
     * 根据关键词进行搜索获取图书ID
     * 
     * @param keyword
     * @param pageSize
     * @param pageIndex
     * @return 图书ID
     */
    List<String> getBookIdsByKeyword(String keyword, int pageSize, int pageIndex);

    /**
     * 添加图书到索引
     * 
     * @param book
     * @return 添加结果
     */
    boolean addBookToIndex(Book book);
}
