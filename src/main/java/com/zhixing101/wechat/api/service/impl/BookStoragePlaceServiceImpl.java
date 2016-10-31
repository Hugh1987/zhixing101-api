package com.zhixing101.wechat.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zhixing101.wechat.api.dao.BookStoragePlaceMapper;
import com.zhixing101.wechat.api.entity.BookStoragePlace;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.BookStoragePlaceService;

@Service("bookStoragePlaceServiceImpl")
public class BookStoragePlaceServiceImpl extends BasicService implements BookStoragePlaceService {

    private static final Logger logger = LoggerFactory.getLogger(BookStoragePlaceServiceImpl.class);

    @Autowired
    BookStoragePlaceMapper bookStoragePlaceMapper;

    public boolean saveBookStoragePlace(BookStoragePlace bookStoragePlace) {

        logger.debug("BookStoragePlaceServiceImpl#saveBookStoragePlace begin");
        logger.debug("BookStoragePlace to handle : " + bookStoragePlace);

        // 处理成功flag初始化为false
        boolean successFlag = false;

        try {
            // 保存bookStoragePlace对象到百度LBS云
            // TODO
            // 保存bookStoragePlace对象到数据库
            bookStoragePlaceMapper.saveBookStoragePlace(bookStoragePlace);
            // 处理成功
            successFlag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.debug("BookStoragePlaceServiceImpl#saveBookStoragePlace successFlag : " + successFlag);
        logger.debug("BookStoragePlaceServiceImpl#saveBookStoragePlace end");
        return successFlag;
    }

}