package com.zhixing101.wechat.api.exception;

/**
 * 业务异常类
 *
 */
public class ZhixingException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1089029973656073789L;

    private Integer status;

    private String message;

    public ZhixingException() {
        super();
    }

    public ZhixingException(String message) {
        super(message);
        this.message = message;
    }

    public ZhixingException(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
