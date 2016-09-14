package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * Created by adam on 10/9/16.
 */
public class BookStorageHistory extends BaseEntity {

    private Integer id;
    private User userId;
    private BookStoragePlace storagePlaceId;
    private Timestamp lastViewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public BookStoragePlace getStoragePlaceId() {
        return storagePlaceId;
    }

    public void setStoragePlaceId(BookStoragePlace storagePlaceId) {
        this.storagePlaceId = storagePlaceId;
    }

    public Timestamp getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Timestamp lastViewTime) {
        this.lastViewTime = lastViewTime;
    }
}
