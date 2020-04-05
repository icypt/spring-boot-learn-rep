package com.icypt.sboot.common.exception;


import com.icypt.sboot.common.result.CodeMsg;

/**
 * 定义系统异常类
 */
public class SysException extends RuntimeException {
    /**
     * 异常码及对应异常信息
     */
    private CodeMsg codeMsg;

    /**
     * 无参构造
     */
    public SysException () {}

    /**
     * 自定义异常信息
     * @param codeMsg
     */
    public SysException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }

    /**
     * 自定义异常信息
     * @param codeMsg
     */
    public SysException(CodeMsg codeMsg, Exception e) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
        e.printStackTrace();
    }

    /**
     * 获取异常信息
     * @return
     */
    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
