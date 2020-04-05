package com.icypt.sboot.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.*;
@PropertySource("classpath:config/application.yml")
@Configuration
public class MyBean {

    @Value("${db.name}")
    public String name;

    @Value("${spring.security.user.password}")
    private String secret;

}