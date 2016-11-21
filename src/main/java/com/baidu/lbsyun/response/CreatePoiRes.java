package com.baidu.lbsyun.response;

/**
 * 创建数据(POI)响应
 */
public class CreatePoiRes {

    /**
     * 状态码(0代表成功，其它取值含义另行说明)
     */
    private int status;

    /**
     * 响应的信息(状态码描述)
     */
    private String message;

    /**
     * 新增的数据的id
     */
    private String id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
