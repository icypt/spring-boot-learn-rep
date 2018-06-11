package com.icypt.learning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 17:12
 * version：1.0
 * description：切面编程日志记录组件
 */
@Aspect
@Component
public class LogAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.icypt.learning.controller.GrilController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"_"+joinPoint.getSignature().getName());
        //args
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        LOGGER.info("return={}", object.toString());
    }
}
