package com.icypt.learning.enums;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 22:43
 * version：1.0
 * description：
 */
public enum  ExceptionEnum {
    SUCCESS("000000","成功"),
    ERROR("FFFFFF","系統错误"),
    WEI_CHENG_NIAN("ERR_10001","未满18岁"),
    ;
    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
