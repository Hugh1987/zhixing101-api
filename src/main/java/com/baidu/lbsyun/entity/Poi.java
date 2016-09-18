package com.baidu.lbsyun.entity;

/**
 * 位置数据（poi）实体
 */
public class Poi {

    /**
     * id
     */
    private long id;

    /**
     * 名称
     */
    private String title;

    /**
     * 分类标签
     */
    private String tags;

    /**
     * 坐标
     */
    private long[] location;

    /**
     * 坐标类型
     */
    private int coord_type;

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
     * 地址
     */
    private String address;

    /**
     * 所属geotable id
     */
    private long geotable_id;

    /**
     * 创建时间
     */
    private long create_time;

    /**
     * 最后一次修改的时间
     */
    private long modify_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long[] getLocation() {
        return location;
    }

    public void setLocation(long[] location) {
        this.location = location;
    }

    public int getCoord_type() {
        return coord_type;
    }

    public void setCoord_type(int coord_type) {
        this.coord_type = coord_type;
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

    public long getGeotable_id() {
        return geotable_id;
    }

    public void setGeotable_id(long geotable_id) {
        this.geotable_id = geotable_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getModify_time() {
        return modify_time;
    }

    public void setModify_time(long modify_time) {
        this.modify_time = modify_time;
    }

}
