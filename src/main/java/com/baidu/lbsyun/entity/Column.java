package com.baidu.lbsyun.entity;

import com.baidu.lbsyun.common.BaiduLbsConstants;

/**
 * 自定义扩展列（column）实体
 */
public class Column {

    /**
     * id
     */
    private long id;

    /**
     * key
     */
    private String key;

    /**
     * 对column的描述或释义
     */
    private String name;

    /**
     * 字段类型
     */
    private int type;

    /**
     * 最大长度
     */
    private int max_length;

    /**
     * 默认值
     */
    private String default_value = BaiduLbsConstants.DEFAULT_VALUE_DEFAULT_VALUE;

    /**
     * 是否为云存储所用的索引字段
     */
    private int is_index_field;

    /**
     * 是否为云存储所用的唯一索引字段
     */
    private int is_unique_field;

    /**
     * 是否为云检索所用的文本检索字段
     */
    private int is_search_field;

    /**
     * 是否为云检索所用的排序筛选字段
     */
    private int is_sortfilter_field;

    /**
     * 排序筛选字段id
     */
    private long sortfilter_id;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    public int getIs_index_field() {
        return is_index_field;
    }

    public void setIs_index_field(int is_index_field) {
        this.is_index_field = is_index_field;
    }

    public int getIs_unique_field() {
        return is_unique_field;
    }

    public void setIs_unique_field(int is_unique_field) {
        this.is_unique_field = is_unique_field;
    }

    public int getIs_search_field() {
        return is_search_field;
    }

    public void setIs_search_field(int is_search_field) {
        this.is_search_field = is_search_field;
    }

    public int getIs_sortfilter_field() {
        return is_sortfilter_field;
    }

    public void setIs_sortfilter_field(int is_sortfilter_field) {
        this.is_sortfilter_field = is_sortfilter_field;
    }

    public long getSortfilter_id() {
        return sortfilter_id;
    }

    public void setSortfilter_id(long sortfilter_id) {
        this.sortfilter_id = sortfilter_id;
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
