package com.zhixing101.wechat.api.entity.req;

import java.io.Serializable;

/**
 * 创建存书点请求
 *
 */
public class CreateBookStoragePlaceRequest implements Serializable {

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
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 存放点所有人微信OpenID
     */
    private String wechatOpenId;

    /**
     * 开放时间
     */
    private String openTime;

    /**
     * 交通
     */
    private String traffic;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "CreateBookStoragePlaceRequest [poiId=" + poiId + ", name=" + name + ", description=" + description
                + ", longtitude=" + longtitude + ", latitude=" + latitude + ", province=" + province + ", city=" + city
                + ", district=" + district + ", address=" + address + ", phone=" + phone + ", mobilePhone="
                + mobilePhone + ", wechatOpenId=" + wechatOpenId + ", openTime=" + openTime + ", traffic=" + traffic
                + "]";
    }

}
