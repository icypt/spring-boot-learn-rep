package com.icypt.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbootAGeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SbootAGeApplication.class, args);
	}
}
