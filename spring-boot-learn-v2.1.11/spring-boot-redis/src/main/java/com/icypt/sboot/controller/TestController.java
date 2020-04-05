package com.icypt.sboot.controller;

import com.icypt.sboot.common.CookieUtil;
import com.icypt.sboot.session.UserInfo;
import com.icypt.sboot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class TestController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping("toLogin")
    public String toLogin(UserInfo userInfo) {
        return "login";
    }

    @RequestMapping("login")
    public String login(@Valid UserVo userVo, Errors errors, Model model, HttpServletResponse resp) {
        //校验参数
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getFieldErrors());
            return "login";
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userVo.getUserName());
        userInfo.setPassword(userVo.getPassword());
        //业务验证登录成功省略
        String token =  UUID.randomUUID().toString();
        userInfo.setToken(token);
        redisTemplate.opsForValue().set("token_create_time", System.currentTimeMillis());
        redisTemplate.opsForValue().set("token_" + token, userInfo,1, TimeUnit.MINUTES);
        //将token保存至cookie
        CookieUtil.setCookie(resp, "token", token, -1);
        return "redirect:toIndex";
    }

    @RequestMapping("toIndex")
    public String toIndex(UserInfo userInfo) {
        return "index";
    }

    @RequestMapping("/toLoginOut")
    public String toLoginOut(UserInfo userInfo) {
        redisTemplate.delete("token_"+userInfo.getToken());
        return "login";
    }

}
