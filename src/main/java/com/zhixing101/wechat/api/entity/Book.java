package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * 图书实体类 Created by adam on 10/9/16.
 */
public class Book extends BaseEntity {

    private Long id; // ID
    private String titleAuthor; // 题名与责任者
    private String title; // 题名
    private String version; // 版本
    private String publication; // 出版发行项
    private String author; // 作者
    private String publisher; // 出版社
    private String binding; // 载体形态项
    private String language; // 语言
    private String generalNote; // 一般附注项
    private String summary; // 摘要
    private String isbn10; // ISBN_10
    private String isbn13; // ISBN_13
    private String keywords; // 主题词
    private String chnCateId; // 中图法分类号
    private String indexId; // 索书号
    private String price; // 定价
    private Bookshelf bookshelf; // 所属书架
    private String position; // 具体存放位置
    private Integer isBorrowed; // 借阅状态
    private String frontCover; // 正面照片ID
    private String backbone; // 书脊照片ID
    private String backCover; // 封底照片ID
    private String doubanImageUrl; // 豆瓣图书图片URL
    private User creator; // 创建者
    private Timestamp createTime; // 创建时间
    private User updateUser; // 更新者
    private Timestamp updateTime; // 更新时间
    private Integer isDeleted; // 删除标志

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleAuthor() {
        return titleAuthor;
    }

    public void setTitleAuthor(String titleAuthor) {
        this.titleAuthor = titleAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGeneralNote() {
        return generalNote;
    }

    public void setGeneralNote(String generalNote) {
        this.generalNote = generalNote;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getChnCateId() {
        return chnCateId;
    }

    public void setChnCateId(String chnCateId) {
        this.chnCateId = chnCateId;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Integer isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public String getBackbone() {
        return backbone;
    }

    public void setBackbone(String backbone) {
        this.backbone = backbone;
    }

    public String getBackCover() {
        return backCover;
    }

    public void setBackCover(String backCover) {
        this.backCover = backCover;
    }

    public String getDoubanImageUrl() {
        return doubanImageUrl;
    }

    public void setDoubanImageUrl(String doubanImageUrl) {
        this.doubanImageUrl = doubanImageUrl;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
