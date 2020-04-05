package com.icypt.sboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/getUserInfo")
    public Object getUserInfo() {
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("name", "张三");
        userInfo.put("age", 10);
        logger.debug("test  debug");
        logger.info("test info");
        logger.warn("test warn");
        logger.error("test error");
        return userInfo;
    }
}
