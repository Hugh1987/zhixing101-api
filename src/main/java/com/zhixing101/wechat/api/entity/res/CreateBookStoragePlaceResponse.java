package com.zhixing101.wechat.api.entity.res;

import java.io.Serializable;

/**
 * 创建存书点响应
 *
 */
public class CreateBookStoragePlaceResponse implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -3724012974804766963L;

    /**
     * 返回码
     */
    private Integer status;

    /**
     * id
     */
    private Long id;

    /**
     * 消息
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateBookStoragePlaceResponse [status=" + status + ", id=" + id + ", message=" + message + "]";
    }

}
