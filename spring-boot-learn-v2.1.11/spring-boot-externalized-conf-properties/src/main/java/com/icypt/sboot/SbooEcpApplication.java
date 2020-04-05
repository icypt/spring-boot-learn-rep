package com.icypt.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication()
@EnableConfigurationProperties
public class SbooEcpApplication {
	public static void main(String[] args) {
		SpringApplication.run(SbooEcpApplication.class, args);
	}
}
