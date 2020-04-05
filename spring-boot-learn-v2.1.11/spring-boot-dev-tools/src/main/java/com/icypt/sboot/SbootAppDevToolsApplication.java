package com.icypt.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SbootAppDevToolsApplication {
	public static void main(String[] args) {
		//完全禁用重新启动功能
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SbootAppDevToolsApplication.class, args);
	}
}
