package com.icypt.sboot.controller;

import com.icypt.sboot.bean.MyBean;
import com.icypt.sboot.config.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private AcmeProperties acmeProperties;

	@Autowired
	private MyBean myBean;

	@RequestMapping("/testReq")
	public Object testReq() {
		return "ok";
	}

	@RequestMapping("/getName")
	public Object getName() {
		return myBean.name;
	}

	@RequestMapping("/getAcmeProperties")
	public Object getAcmeProperties() {
		return acmeProperties;
	}
}
