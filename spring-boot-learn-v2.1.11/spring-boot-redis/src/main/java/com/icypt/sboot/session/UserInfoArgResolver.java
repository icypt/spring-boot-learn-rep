package com.icypt.sboot.session;

import com.icypt.sboot.common.CookieUtil;
import com.icypt.sboot.session.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * PlatForm： 冰点IT
 * projectName: spring-boot-learn
 * Author：icypt
 * CreateTime： 2020/4/4 23:24
 * Version：2.0
 * Description： session信息绑定
 * URL: www.icypt.com
 */
@Component
public class UserInfoArgResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType() == UserInfo.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String mToken = request.getParameter("token");
        String cToken = CookieUtil.getCookieValue(request, "token");
        String token = StringUtils.isBlank(cToken)? mToken: cToken;
        if(StringUtils.isBlank(token)) {
            return null;
        }
        //根据token信息查询session信息存在，则将session信息放置model，便也视图使用
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get("token_" + token);
        if(userInfo != null) {
            modelAndViewContainer.addAttribute("userInfo", userInfo);
            return userInfo;
        }
        return null;
    }
}
