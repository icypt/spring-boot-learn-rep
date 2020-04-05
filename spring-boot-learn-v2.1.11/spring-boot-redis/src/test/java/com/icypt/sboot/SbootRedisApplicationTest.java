package com.icypt.sboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * PlatForm： 冰点IT
 * projectName: SpringBoot 学习
 * Author：icypt
 * CreateTime： 2020/4/3 22:35
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testSet() {
        String key = "testkey";
        redisTemplate.opsForValue().set(key, "test");
    }

    @Test
    public void testGet() {
        String key = "testkey";
        System.out.println(redisTemplate.opsForValue().get(key));
    }
}
