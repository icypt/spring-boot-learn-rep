package com.icypt.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@Controller
public class TestController {
	
	@RequestMapping("/testReq")
	@ResponseBody
	public Object testReq() {
		return "ok";
	}

	@RequestMapping("/toTest")
	public String toTest() {
		return "test";
	}
}
