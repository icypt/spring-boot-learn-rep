package com.icypt.learning.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/19 23:22
 * version：1.0
 * description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GrilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAge() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/findAllGrils")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}