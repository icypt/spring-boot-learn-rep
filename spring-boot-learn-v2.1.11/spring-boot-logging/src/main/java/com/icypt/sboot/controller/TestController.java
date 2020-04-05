package com.icypt.sboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	public static Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/testReq")
	public Object testReq() {
		logger.info("测试 level info");
		logger.debug("测试 level debug");
		return "ok";
	}

}
