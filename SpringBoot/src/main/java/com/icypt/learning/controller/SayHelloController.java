package com.icypt.learning.controller;

import com.icypt.learning.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ICYPT on 2018/5/17.
 */
@RestController
public class SayHelloController {

    @Autowired
    private GirlConfig grilConfig;
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return grilConfig.getContent();
    }

}
