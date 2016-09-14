package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * 图书实体类
 * Created by adam on 10/9/16.
 */
public class Book extends BaseEntity {

    private Integer id;                 //ID
    private String titleAuthor;         //题名与责任者
    private String title;               //题名
    private String version;             //版本
    private String publication;         //出版发行项
    private String author;              //作者
    private String press;               //出版社
    private String carrierForm;         //载体形态
    private String language;            //语种
    private String generalNote;         //一般附注
    private String summary;             //摘要
    private String isbn;                //isbn
    private String keywords;            //关键词
    private String chnCateId;           //中图法分类号
    private String indexId;             //索书号
    private String price;               //定价
    private BookShelf bookShelf;        //书架ID
    private String position;            //具体位置
    private Boolean isBorrowed;         //是否出借状态
    private String frontCover;          //封面图
    private String backbone;            //书脊图
    private String backCover;           //封底图
    private User creator;               //发布人
    private Timestamp createTime;       //发布时间
    private User updateUser;            //更新人
    private Timestamp updateTime;       //更新时间
    private Boolean isDelete;           //删除状态


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCarrierForm() {
        return carrierForm;
    }

    public void setCarrierForm(String carrierForm) {
        this.carrierForm = carrierForm;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
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
