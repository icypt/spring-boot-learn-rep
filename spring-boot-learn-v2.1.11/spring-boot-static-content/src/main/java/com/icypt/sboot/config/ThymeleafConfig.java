package com.icypt.sboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

/**
 * PlatForm：冰点IT
 * projectName: SpringBoot学习
 * Author：icypt
 * CreateTime： 2020/1/19 16:05
 * Version：2.0
 * Description：thyeleaf版本控制失效问题配置
 * URL: www.icypt.com
 */
@Configuration
public class ThymeleafConfig {
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}

