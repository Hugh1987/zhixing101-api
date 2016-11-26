package com.zhixing101.wechat.api.entity.req;

import java.io.Serializable;

/**
 * 创建存书点请求
 *
 */
public class CreateBookStoragePlaceRequest implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6930983721728992226L;

    /**
     * 位置数据POI ID
     */
    private String poiId;

    /**
     * 存放点名称
     */
    private String name;

    /**
     * 存放点描述
     */
    private String description;

    /**
     * 经度
     */
    private String longtitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 存放点所有人微信OpenID
     */
    private String wechatOpenId;

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    @Override
    public String toString() {
        return "CreateBookStoragePlaceRequest [poiId=" + poiId + ", name=" + name + ", description=" + description
                + ", longtitude=" + longtitude + ", latitude=" + latitude + ", wechatOpenId=" + wechatOpenId + "]";
    }
}
