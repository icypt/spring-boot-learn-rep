package com.icypt.sboot.common;

public class SessionUtil {
    public static final String REDIS_SC_BASE_KEY = "session_container";

    public static final String COOKIE_SC_KEY = "token";


    /**
     * Session容器在Redis中的key值
     * @param token
     * @return
     */
    public static  String buildSCRedisKey(String token) {
        return REDIS_SC_BASE_KEY + "_" + token;
    }
}
