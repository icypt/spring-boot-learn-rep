package com.icypt.sboot.controller;

import com.icypt.sboot.common.SessionUtil;
import com.icypt.sboot.session.SessionContainer;
import com.icypt.sboot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.Serializable;

@Controller
public class TestController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String login(@Valid UserVo userVo, Errors errors, Model model, SessionContainer sc) {
        //校验参数
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getFieldErrors());
            return "login";
        }
        sc.setAttribute("userInfo", userVo);
        return "redirect:toIndex";
    }

    @RequestMapping("toIndex")
    public String toIndex(Model model, SessionContainer sc) {
        model.addAttribute("userInfo", sc.getAttribute("userInfo"));
        return "index";
    }

    @RequestMapping("/toLoginOut")
    public String toLoginOut(SessionContainer sc) {
        redisTemplate.delete(SessionUtil.buildSCRedisKey(sc.getToken()));
        return "login";
    }

}
