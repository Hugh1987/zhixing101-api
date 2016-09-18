package com.baidu.lbsyun.entity;

/**
 * 位置数据表（geotable）实体
 */
public class Geotable {

    /**
     * id
     */
    private long id;

    /**
     * 用户id
     */
    private long user_id;

    /**
     * 数据类型
     */
    private int geotype;

    /**
     * 创建的时间
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getGeotype() {
        return geotype;
    }

    public void setGeotype(int geotype) {
        this.geotype = geotype;
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
