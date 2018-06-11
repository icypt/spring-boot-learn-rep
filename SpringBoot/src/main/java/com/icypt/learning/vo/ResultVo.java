package com.icypt.learning.vo;

import java.io.Serializable;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 20:29
 * version：1.0
 * description：结果集封装
 */
public class ResultVo implements Serializable{
    private static final long serialVersionUID = 7015557510677525021L;
    /**
     *返回码：000000，成功码；FFFFFF，系统异常码；其他：系统自定义返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public ResultVo() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
