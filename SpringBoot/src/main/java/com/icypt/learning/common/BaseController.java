package com.icypt.learning.common;

import com.icypt.learning.enums.ExceptionEnum;
import com.icypt.learning.vo.ResultVo;

public class BaseController {

    //成功返回携带数据对象
    public ResultVo success(Object obj) {
        ResultVo resultVo = success();
        resultVo.setData(obj);
        return resultVo;
    }

    //成功返回只携带状态
    public ResultVo success() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ExceptionEnum.SUCCESS.getCode());
        resultVo.setMessage(ExceptionEnum.SUCCESS.getMessage());
        return resultVo;
    }
}
