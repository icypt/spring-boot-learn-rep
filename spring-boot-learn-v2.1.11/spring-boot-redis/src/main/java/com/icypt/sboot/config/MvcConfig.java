package com.icypt.sboot.config;

import com.icypt.sboot.session.SessionFilter;
import com.icypt.sboot.session.UserInfoArgResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PlatForm： 冰点IT
 * projectName: spring-boot-learn
 * Author：icypt
 * CreateTime： 2020/4/4 23:19
 * Version：2.0
 * Description：mvc配置
 * URL: www.icypt.com
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private SessionFilter sessionFilter;

    @Value("${spring.session.url.exclude}")
    private String excludeUrl;

    @Autowired
    private UserInfoArgResolver userInfoArgResolver;


    /**
     * 增加参数解析器
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userInfoArgResolver);
    }

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(sessionFilter);
        filterRegistrationBean.setName("sessionFilter");
        List<String> urlPattern = new ArrayList<>();
        urlPattern.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPattern);
        Map<String, Object> excludeUrlMap = new HashMap<>();
        excludeUrlMap.put("excludeUrl", excludeUrl);
        filterRegistrationBean.setInitParameters(excludeUrlMap);
        return filterRegistrationBean;
    }
}
