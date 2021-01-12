package com.icypt.sboot.common;

public class RedisUtil {
    /**
     * 生成Redis的key
     * @param basePrefix
     * @param businessKey
     * @return
     */
    public String buildRedisKey(String basePrefix, String businessKey) {
        return basePrefix + businessKey;
    }
}
