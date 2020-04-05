package com.icypt.learning.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/6/5 19:56
 * version：1.0
 * description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest1 {
    private static Logger logger = LoggerFactory.getLogger(LogTest1.class);
    @Test
    public void test1() {
        logger.debug("debug---------------");
        logger.info("info--------------");
        logger.error("error--------------------");
    }
}
