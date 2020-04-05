package com.icypt.sboot.common.exception;

import com.icypt.sboot.common.result.CodeMsgFactory;
import com.icypt.sboot.common.result.Result;
import com.icypt.sboot.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class ExceptionController implements ErrorController {

    public static Logger LOG = LoggerFactory.getLogger(ExceptionController.class);

    //默认请求地址
    private static final  String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * web页面异常请求处理
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = MediaType.TEXT_HTML_VALUE)
    public String handlePageError(HttpServletRequest request) {
        LOG.info("进入异常跳转");
        Integer statusCode = getStatus(request);
        switch (statusCode) {
            case 404:
                LOG.info("404异常跳转");
                return "error/404";
            case 403:
                LOG.info("403异常跳转");
                return "error/403";
            case 500:
                LOG.info("500异常跳转");
                return "error/500";
            default:
                LOG.info("默认异常跳转");
                return "error/404";
        }

    }

    /**
     * 其他异常请求处理，例如：contentType：application/json等
     * @param request
     * @return
     */
    @RequestMapping(ERROR_PATH)
    @ResponseBody
    public Result handleAllError(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Integer statusCode = getStatus(request);
        Map<String, Object> body = this.errorAttributes.getErrorAttributes(webRequest, false);
        body.put("status", statusCode);
        return ResultUtil.result(CodeMsgFactory.REQ_EXCEPTION, body);
    }

    /**
     * 获取状态码
     * @param request
     * @return
     */
    public Integer getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return 500;
        }
        return  statusCode;
    }

    /**
     * Spring 默认错误页路径
     * @return
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
