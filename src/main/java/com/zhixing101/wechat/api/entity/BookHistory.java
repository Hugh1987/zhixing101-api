package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * Created by adam on 10/9/16.
 */
public class BookHistory extends BaseEntity {

    private Integer id;                         //id
    private User userId;                        //用户ID
    private Book bookId;                        //书籍ID
    private Timestamp lastViewTime;             //浏览时间

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

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Timestamp getLastViewTime() {
        return lastViewTime;
    }

    public void setLastViewTime(Timestamp lastViewTime) {
        this.lastViewTime = lastViewTime;
    }
}
