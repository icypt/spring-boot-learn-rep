package com.icypt.sboot.session;

import com.icypt.sboot.common.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Service
public class SessionContainerServiceRedisImpl implements SessionContainerService {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public void save(SessionContainer sc) {
        redisTemplate.opsForValue().set(SessionUtil.buildSCRedisKey(sc.getToken()), sc, SessionContainer.TIME_OUT, TimeUnit.MILLISECONDS);
    }

    @Override
    public void update(SessionContainer sc) {
        this.save(sc);
    }

    @Override
    public void refresh(SessionContainer sc) {
        this.save(sc);
    }

    @Override
    public SessionContainer get(String token) {
        return (SessionContainer)redisTemplate.opsForValue().get(SessionUtil.buildSCRedisKey(token));
    }
}
