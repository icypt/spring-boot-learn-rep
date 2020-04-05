package com.icypt.sboot.controller;

import com.icypt.sboot.common.exception.SysException;
import com.icypt.sboot.common.result.CodeMsgFactory;
import com.icypt.sboot.common.result.Result;
import com.icypt.sboot.common.result.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/getInfo/{id}")
    @ResponseBody
    public Result getInfoById(@PathVariable(name = "id") String id) {
        if("test".equalsIgnoreCase(id)){
            return ResultUtil.succ(id);
        } else {
            throw new SysException(CodeMsgFactory.REQ_PARAM_ERROR);
        }
    }

}
