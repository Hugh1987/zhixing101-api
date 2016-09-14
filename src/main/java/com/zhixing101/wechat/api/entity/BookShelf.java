package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * Created by adam on 10/9/16.
 */
public class BookShelf extends BaseEntity {

    private Integer id;                 //id
    private String name;                //名称
    private String floor;               //楼层
    private String room;                //房间号
    private String bookshelfPic;        //书架图片
    private String longtitude;          //经度
    private String latitude;            //纬度
    private BookStoragePlace bookStoragePlace;    //所属书籍存放点
    private User creator;             //发布人
    private Timestamp createTime;            //发布时间
    private User updateUser;          //更新人
    private Timestamp updateTime;            //更新时间
    private Boolean isDelete;           //删除状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBookshelfPic() {
        return bookshelfPic;
    }

    public void setBookshelfPic(String bookshelfPic) {
        this.bookshelfPic = bookshelfPic;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public BookStoragePlace getBookStoragePlace() {
        return bookStoragePlace;
    }

    public void setBookStoragePlace(BookStoragePlace bookStoragePlace) {
        this.bookStoragePlace = bookStoragePlace;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
