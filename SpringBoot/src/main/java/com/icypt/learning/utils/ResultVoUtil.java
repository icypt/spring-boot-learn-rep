package com.icypt.learning.utils;

import com.icypt.learning.enums.ExceptionEnum;
import com.icypt.learning.vo.ResultVo;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 20:40
 * version：1.0
 * description：结果集工具类
 */
public class ResultVoUtil {

    /**
     * 返回成功
     * @param data
     * @return
     */
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ExceptionEnum.SUCCESS.getCode());
        resultVo.setMessage(ExceptionEnum.SUCCESS.getMessage());
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 返回成功
     * @return
     */
    public static ResultVo success() {
        return success(null);
    }

    /**
     * 返回失败
     * @param code
     * @param message
     * @return
     */
    public static ResultVo error(String code, String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return resultVo;
    }
}
