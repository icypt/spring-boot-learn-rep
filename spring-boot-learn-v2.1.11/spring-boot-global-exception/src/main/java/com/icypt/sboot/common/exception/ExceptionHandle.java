package com.icypt.sboot.common.exception;

import com.icypt.sboot.common.result.ResultUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PlatForm：冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/2/17 17:00
 * Version：2.0
 * Description：全局异常处理，未知异常跳转至500页面，系统异常返回错误码和错误信息
 * URL: www.icypt.com
 */
@Component
@ControllerAdvice
public class ExceptionHandle {
    /**
     * 系统异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = SysException.class)
    @ResponseBody
    public Object systemExceptionHandle(SysException e) {
        e.printStackTrace();
        return ResultUtil.result(e.getCodeMsg());
    }
}
