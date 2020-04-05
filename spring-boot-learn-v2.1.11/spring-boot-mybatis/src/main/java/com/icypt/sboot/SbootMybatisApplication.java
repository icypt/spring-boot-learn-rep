package com.icypt.sboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//扫描mapper
@MapperScan("com.icypt.sboot.mapper")
@SpringBootApplication
public class SbootMybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SbootMybatisApplication.class, args);
	}
}
