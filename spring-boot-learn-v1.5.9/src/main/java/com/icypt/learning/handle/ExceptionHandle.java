package com.icypt.learning.handle;

import com.icypt.learning.SystemException;
import com.icypt.learning.enums.ExceptionEnum;
import com.icypt.learning.utils.ResultVoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 21:01
 * version：1.0
 * description：
 */
@Component
@ControllerAdvice
public class ExceptionHandle {
    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object excptionHandle(Exception e) {
        if(e instanceof SystemException) {
            SystemException systemException = (SystemException)e;
            return ResultVoUtil.error(systemException.getCode(), systemException.getMessage());
        } else {
            LOGGER.error("【系统错误】{}",e);
            return ResultVoUtil.error(ExceptionEnum.ERROR.getCode(),
                    ExceptionEnum.ERROR.getMessage());
        }
    }
}
