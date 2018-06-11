package com.icypt.learning.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 22:55
 * version：1.0
 * description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GrilServiceTest {
    @Autowired
    private GrilService grilService;
    @Test
    public void getAge() throws Exception {
        int age = grilService.getAge(8);
        Assert.assertEquals(19, age);
    }

}