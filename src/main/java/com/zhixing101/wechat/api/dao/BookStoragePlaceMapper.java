package com.zhixing101.wechat.api.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhixing101.wechat.api.entity.BookStoragePlace;

/**
 * Created by adam on 10/9/16.
 */
@Repository("bookStoragePlaceMapper")
public interface BookStoragePlaceMapper {

    boolean saveBookStoragePlace(@Param("bookStoragePlace") BookStoragePlace bookStoragePlace);

}
