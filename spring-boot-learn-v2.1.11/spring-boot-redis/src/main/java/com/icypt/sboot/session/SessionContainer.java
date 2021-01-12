package com.icypt.sboot.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icypt.sboot.common.CookieUtil;
import com.icypt.sboot.common.JsonUtils;
import com.icypt.sboot.common.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Session容器
 */
@Component
public class SessionContainer implements Serializable {

    @Autowired
    private SessionContainerService sessionContainerService;
    //session超时时间
    public static final Long TIME_OUT = 30 * 60 * 1000L;

    //Session唯一标识
    private String token;
    //Session创建时间
    private Date createTime;
    //Session容器
    private Map<String, Object>  container;

    public SessionContainer init(String token) {
        this.token = token;
        this.createTime = new Date();
        this.container = new HashMap<>();
        return this;
    }

    public SessionContainer init() {
        return this.init(createToken());
    }

    //设置Session属性
    public void setAttribute(String key, Object value) {
        container.put(key, value);
        sessionContainerService.update(this);
    }

    //获取Session属性
    public Object getAttribute(String key) {
       return container.get(key);
    }

    //删除Session属性
    public void removeAttribute(String key) {
        if(container.containsKey(key)) {
            container.remove(key);
            sessionContainerService.update(this);
        }
    }

    //设置Session创建时间
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    //获取Session创建时间
    public Date getCreateTime() {
        return createTime;
    }

    //判断Session是否过期
    @JsonIgnore
    public Boolean isExpired() {
        if(this.createTime != null) {
            if((System.currentTimeMillis() - this.createTime.getTime()) < TIME_OUT) {
                return true;
            }
        }
        return false;
    }

    //获取token
    public String getToken() {
        return token;
    }

    //生成Token
    public synchronized String createToken() {
        return UUID.randomUUID().toString();
    }


    /** 以下三个方法用于序列化时使用 */
    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getContainer() {
        return container;
    }

    public void setContainer(Map<String, Object> container) {
        this.container = container;
    }
}
