package com.baidu.lbsyun.request;

import com.zhixing101.wechat.api.entity.BookStoragePlace;

/**
 * 创建数据(POI)请求
 */
public class CreatePoiReq {

    /**
     * poi名称(可选)
     */
    private String title;

    /**
     * 地址(可选)
     */
    private String address;

    /**
     * tags(可选)
     */
    private String tags;

    /**
     * 用户上传的纬度(必选)
     */
    private double latitude;

    /**
     * 用户上传的经度(必选)
     */
    private double longitude;

    /**
     * 用户上传的坐标的类型(必选)
     */
    private int coord_type;

    /**
     * 记录关联的geotable的标识(必选)
     */
    private String geotable_id;

    /**
     * 用户的访问权限key(必选)
     */
    private String ak;

    /**
     * 用户的权限签名(可选)
     */
    private String sn;

    /**
     * 存放点描述(开发者自定义)
     */
    private String description;

    /**
     * 删除标志(开发者自定义)
     */
    private int delete_flag;

    /**
     * 交通(开发者自定义)
     */
    private String traffic;

    /**
     * 开放时间(开发者自定义)
     */
    private String open_time;

    /**
     * 存放点所有人ID(开发者自定义)
     */
    private String owner_user_id;

    /**
     * 手机(开发者自定义)
     */
    private String mobile_phone;

    /**
     * 联系电话(开发者自定义)
     */
    private String phone;

    /**
     * 存放点名称(开发者自定义)
     */
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCoord_type() {
        return coord_type;
    }

    public void setCoord_type(int coord_type) {
        this.coord_type = coord_type;
    }

    public String getGeotable_id() {
        return geotable_id;
    }

    public void setGeotable_id(String geotable_id) {
        this.geotable_id = geotable_id;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getOwner_user_id() {
        return owner_user_id;
    }

    public void setOwner_user_id(String owner_user_id) {
        this.owner_user_id = owner_user_id;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreatePoiReq [title=" + title + ", address=" + address + ", latitude=" + latitude + ", longitude="
                + longitude + ", coord_type=" + coord_type + ", geotable_id=" + geotable_id + ", ak=" + ak
                + ", description=" + description + ", name=" + name + "]";
    }

    public CreatePoiReq(String tags, int coord_type, String geotable_id, String ak, BookStoragePlace bookStoragePlace) {
        this.title = bookStoragePlace.getName();
        this.address = bookStoragePlace.getAddress();
        this.tags = tags;
        this.latitude = Double.parseDouble(bookStoragePlace.getLatitude());
        this.longitude = Double.parseDouble(bookStoragePlace.getLongtitude());
        this.coord_type = coord_type;
        this.geotable_id = geotable_id;
        this.ak = ak;
        this.description = bookStoragePlace.getDescription();
        this.delete_flag = bookStoragePlace.getIsDeleted();
        this.traffic = bookStoragePlace.getTraffic();
        this.open_time = bookStoragePlace.getOpenTime();
        this.owner_user_id = String.valueOf(bookStoragePlace.getOwnerUser().getId());
        this.mobile_phone = bookStoragePlace.getMobilePhone();
        this.phone = bookStoragePlace.getPhone();
        this.name = bookStoragePlace.getName();
    }

}
