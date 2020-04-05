package com.icypt.sboot.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：spring-boot-learn
 * CreateTime： 2020/4/4 23:29
 * Version：2.0
 * Description：cookie工具类
 * URL: www.icypt.com
 */
public class CookieUtil {

    /**
     * 获取cookie的值
     * @param request
     * @param key
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if(key.equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    /**
     * 设置cookie
     * @param resp
     * @param key
     * @param value
     * @param timeOut
     */
    public static void setCookie(HttpServletResponse resp,String key, String value, int timeOut) {
        Cookie cookie  = new Cookie(key, value);
        cookie.setMaxAge(timeOut);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }
}
