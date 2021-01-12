package com.icypt.sboot.session;

import com.icypt.sboot.common.CookieUtil;
import com.icypt.sboot.common.SessionUtil;
import com.mysql.cj.Session;
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
    private SessionContainerService sessionContainerService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String cToken = CookieUtil.getCookieValue(req, SessionUtil.COOKIE_SC_KEY);
        String mToken = req.getParameter(SessionUtil.COOKIE_SC_KEY);
        String token = StringUtils.isBlank(cToken) ? mToken : cToken;
        SessionContainer sc = null;
        //判断请求是否携带token
        if(StringUtils.isNotBlank(token)) {
            //根据token获取session信息
            sc = sessionContainerService.get(token);
            if(sc != null) {
                /** Session正常处理 */
                //session存在时，刷新session时间
                if(!sc.isExpired()) {
                    //刷新Session有效时间
                    sessionContainerService.refresh(sc);
                }
            } else {
                /** Session过期处理 */
                //初始化Session容器
                sc = new SessionContainer().init(token);
                //保存至Redis
                sessionContainerService.update(sc);
            }
        } else {
            /** Session第一次初始化 */
            //初始化Session容器
            sc = new SessionContainer().init();
            sessionContainerService.save(sc);
            //将token保存至cookie
            CookieUtil.setCookie(resp, SessionUtil.COOKIE_SC_KEY, sc.getToken(), -1);
        }
        request.setAttribute(SessionUtil.COOKIE_SC_KEY, sc.getToken());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
