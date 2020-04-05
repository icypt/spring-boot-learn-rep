package com.icypt.sboot.session;

import com.icypt.sboot.common.CookieUtil;
import com.icypt.sboot.session.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * PlatForm： 冰点IT
 * projectName:
 * Author：icypt
 * CreateTime： 2020/4/4 23:56
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@Component
public class SessionFilter implements Filter {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    private String [] excludeUrlArray;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String reqUrl = req.getRequestURI();
        String cToken = CookieUtil.getCookieValue(req, "token");
        String mToken = req.getParameter("token");
        String token = StringUtils.isBlank(cToken) ? mToken : cToken;
        //判断请求是否携带token
        if(StringUtils.isNotBlank(token)) {
            //根据token获取session信息
            UserInfo userInfo = (UserInfo)redisTemplate.opsForValue().get("token_" + token);
            if(userInfo != null) {
                //session存在时，刷新session时间
                long tokenCreateTime = (long)redisTemplate.opsForValue().get("token_create_time");
                if((System.currentTimeMillis() - tokenCreateTime) < 60 * 1000) {
                    redisTemplate.expire("token_" + token, 1, TimeUnit.MINUTES);
                }
            }
            //token存在，session信息失效并且不是登录相关请求时，跳转至登录
            if(userInfo == null && isJumpLogin(reqUrl)){
                resp.sendRedirect("toLogin");
                return;
            }
        }
        chain.doFilter(request,response);
    }

    /**
     * 判断是否为跳转至登录或者提交登录的请求
     * @param reqUrl
     * @return
     */
    public boolean isJumpLogin(String reqUrl) {
        boolean flag = true;
        for(String excludeUrl : excludeUrlArray) {
            if(reqUrl.indexOf(excludeUrl) >= 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludeUrl = filterConfig.getInitParameter("excludeUrl");
        excludeUrlArray = excludeUrl.split(",")
        ;
    }

    @Override
    public void destroy() {

    }
}
