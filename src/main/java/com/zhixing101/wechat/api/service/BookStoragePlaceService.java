package com.zhixing101.wechat.api.service;

import com.zhixing101.wechat.api.entity.req.CreateBookStoragePlaceRequest;
import com.zhixing101.wechat.api.entity.res.CreateBookStoragePlaceResponse;

public interface BookStoragePlaceService {

    CreateBookStoragePlaceResponse saveBookStoragePlace(CreateBookStoragePlaceRequest req);
}
