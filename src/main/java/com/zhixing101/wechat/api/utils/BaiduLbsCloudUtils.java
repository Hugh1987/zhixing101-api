package com.zhixing101.wechat.api.utils;

import org.springframework.beans.factory.annotation.Value;

import com.baidu.lbsyun.common.BaiduLbsConstants;
import com.baidu.lbsyun.request.CreatePoiReq;
import com.zhixing101.wechat.api.entity.BookStoragePlace;

/**
 * 百度LBS云 工具类
 */
public class BaiduLbsCloudUtils {

    @Value("#{propertyConfigurer['baidu.ak']}")
    private String ak;
    
    @Value("#{propertyConfigurer['baidu.bookStoragePlaceGeotableId']}")
    private String bookStoragePlaceGeotableId;
    
    public boolean createBookStoragePlace(BookStoragePlace bookStoragePlace) {

        CreatePoiReq createPoiReq = new CreatePoiReq(null, BaiduLbsConstants.COORD_TYPE_BD09,
                bookStoragePlaceGeotableId, ak, bookStoragePlace);

        return false;
    }
}
