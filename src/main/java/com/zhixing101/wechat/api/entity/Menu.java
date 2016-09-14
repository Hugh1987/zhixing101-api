package com.zhixing101.wechat.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 自定义菜单对象
 * Created by adam on 28/2/16.
 */
public class Menu extends BaseEntity {

    @JSONField(serialize = false)
    private Integer id;
    @JSONField(serialize = false)
    private Integer pid;
    private String name;     //菜单名
    private String type;     //菜单类型
    private String url;      //view类型独有
    private String key;      //click类型
    @JSONField(serialize = false)
    private boolean enable;  //是否使用

    private List<Menu> button;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Menu> getButton() {
        return button;
    }

    public void setButton(List<Menu> button) {
        this.button = button;
    }
}
