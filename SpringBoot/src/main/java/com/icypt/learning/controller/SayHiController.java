package com.icypt.learning.controller;

import com.icypt.learning.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ICYPT on 2018/5/17.
 */
@Controller
public class SayHiController {

    @Autowired
    private GirlConfig grilConfig;

    @RequestMapping(value = "/sayHi", method = RequestMethod.GET)
    public String sayHi(Model model) {
        model.addAttribute("icypt", "ceshi");
        return "SayHi";
    }

    @RequestMapping(value = "/sayHiPathVariable/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHiPathVariable(@PathVariable("id") String id) {
        return "id:"+id;
    }

    @RequestMapping(value = "/sayHiRequestParam", method = RequestMethod.POST)
    @ResponseBody
    public String sayHiRequestParam(@RequestParam("id") String id) {
        return "id:"+id;
    }

    @GetMapping("/sayHiGetMapping")
    @ResponseBody
    public String sayHiGetMapping(@RequestParam("id") String id) {
        return "id:"+id;
    }

    @PostMapping("/sayHiPostMapping/{id}")
    @ResponseBody
    public String sayHiPostMapping(@PathVariable("id") String id) {
        return "id:"+id;
    }

    @PostMapping("/sayHiDefaultVal")
    @ResponseBody
    public String sayHiDefaultVal(@RequestParam(value = "id", required = true, defaultValue = "icypt") String id) {
        return "id:"+id;
    }
}
