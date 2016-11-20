package com.baidu.lbsyun.common;

/**
 * 百度LBS常量类
 */
public class BaiduLbsConstants {

    /**
     * geotype数据类型--1：点
     */
    public static final int GEOTYPE_POINT = 1;

    /**
     * geotype数据类型--2：线
     */
    public static final int GEOTYPE_LINE = 2;

    /**
     * geotype数据类型--3：面
     */
    public static final int GEOTYPE_FACE = 3;

    /**
     * 字段类型--1:Int64
     */
    public static final int TYPE_INT64 = 1;

    /**
     * 字段类型--2:double
     */
    public static final int TYPE_DOUBLE = 2;

    /**
     * 字段类型--3:string
     */
    public static final int TYPE_STRING = 3;

    /**
     * 字段类型--4:在线图片URL
     */
    public static final int TYPE_ONLINE_PIC_URL = 4;

    /**
     * 默认值--0
     */
    public static final String DEFAULT_VALUE_DEFAULT_VALUE = "0";

    /**
     * 是否为云存储所用的索引字段--1：是
     */
    public static final int IS_INDEX_FIELD_YES = 1;

    /**
     * 是否为云存储所用的索引字段--0：否
     */
    public static final int IS_INDEX_FIELD_NO = 0;

    /**
     * 是否为云存储所用的唯一索引字段--1：是
     */
    public static final int IS_UNIQUE_FIELD_YES = 1;

    /**
     * 是否为云存储所用的唯一索引字段--0：否
     */
    public static final int IS_UNIQUE_FIELD_NO = 0;

    /**
     * 是否为云检索所用的文本检索字段--1：是
     */
    public static final int IS_SEARCH_FIELD_YES = 1;

    /**
     * 是否为云检索所用的文本检索字段--0：否
     */
    public static final int IS_SEARCH_FIELD_NO = 0;

    /**
     * 是否为云检索所用的排序筛选字段--1：是
     */
    public static final int IS_SORTFILTER_FIELD_YES = 1;

    /**
     * 是否为云检索所用的排序筛选字段--0：否
     */
    public static final int IS_SORTFILTER_FIELD_NO = 0;

    /**
     * 坐标类型--1：GPS经纬度坐标
     */
    public static final int COORD_TYPE_WGS84 = 1;

    /**
     * 坐标类型--2：国测局加密经纬度坐标
     */
    public static final int COORD_TYPE_GCJ02 = 2;

    /**
     * 坐标类型--3：百度加密经纬度坐标
     */
    public static final int COORD_TYPE_BD09 = 3;

    /**
     * 坐标类型--4：百度加密墨卡托坐标
     */
    public static final int COORD_TYPE_BDMCT = 4;

    /**
     * 创建数据（create poi）接口
     */
    public static final String CREATE_POI_URL = "http://api.map.baidu.com/geodata/v3/poi/create";
}
