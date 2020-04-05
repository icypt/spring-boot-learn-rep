package com.icypt.learning;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 21:04
 * version：1.0
 * description：
 */
public class SystemException extends RuntimeException {
    private String code;
    private String message;

    public SystemException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
