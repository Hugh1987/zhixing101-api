package com.zhixing101.wechat.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.zhixing101.wechat.api.dao.BookStoragePlaceMapper;
import com.zhixing101.wechat.api.entity.BookStoragePlace;
import com.zhixing101.wechat.api.entity.req.CreateBookStoragePlaceRequest;
import com.zhixing101.wechat.api.entity.res.CreateBookStoragePlaceResponse;
import com.zhixing101.wechat.api.service.BasicService;
import com.zhixing101.wechat.api.service.BookStoragePlaceService;
import com.zhixing101.wechat.api.utils.BaiduLbsCloudUtils;

@Service("bookStoragePlaceServiceImpl")
public class BookStoragePlaceServiceImpl extends BasicService implements BookStoragePlaceService {

    private static final Logger logger = LoggerFactory.getLogger(BookStoragePlaceServiceImpl.class);

    @Autowired
    BookStoragePlaceMapper bookStoragePlaceMapper;

    public CreateBookStoragePlaceResponse saveBookStoragePlace(CreateBookStoragePlaceRequest req) {

        logger.debug("saveBookStoragePlace begin");
        logger.debug("req = " + req);

        // 初始化返回结果
        CreateBookStoragePlaceResponse res = new CreateBookStoragePlaceResponse();
        res.setId(null);
        res.setStatus(1);
        res.setMessage("failed");

        // 初始化存书点对象
        BookStoragePlace bookStoragePlace = new BookStoragePlace(req);

        try {
            // 保存到百度LBS云
            String poiId = BaiduLbsCloudUtils.createBookStoragePlace(req);

            logger.debug("poiId = " + poiId);

            // 判断百度LBS云保存结果
            if (StringUtils.isEmpty(poiId)) {

                logger.debug("saveBookStoragePlace res = " + res);
                logger.debug("saveBookStoragePlace end");
                return res;
            } else {

                bookStoragePlace.setPoiId(poiId);

                logger.debug("bookStoragePlace =" + bookStoragePlace);

                // 保存到数据库
                boolean result = bookStoragePlaceMapper.saveBookStoragePlace(bookStoragePlace);
                logger.debug("the result of saving bookStoragePlace to = " + result);

                // 更新返回结果
                res.setId(bookStoragePlace.getId());
                res.setStatus(0);
                res.setMessage("succeed");

                logger.debug("saveBookStoragePlace res = " + res);
                logger.debug("saveBookStoragePlace end");
                return res;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }

}
