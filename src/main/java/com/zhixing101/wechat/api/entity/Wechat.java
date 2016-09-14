package com.zhixing101.wechat.api.entity;

import java.sql.Timestamp;

/**
 * 微信账号的实体类
 * Created by adam on 11/12/15.
 */
public class Wechat extends BaseEntity {

    private Integer id;
    private String appid;
    private String appSecret;
    private String token;
    private String cname;
    private String passKey;
    private Timestamp overDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    public Timestamp getOverDate() {
        return overDate;
    }

    public void setOverDate(Timestamp overDate) {
        this.overDate = overDate;
    }
}
