package com.icypt.learning.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class JedisUtil {
    //给某个key设值
    public void set(String key, Object value) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            byte[] valueBytes = serializer.serializeValue(value);
            client.set(keyBytes, valueBytes);
        } finally {
            returnJedis(client);
        }

    }

    //根据key获取value
    public Object get(String key) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            byte[] valueBytes = client.get(keyBytes);
            return serializer.deserializeValue(valueBytes);
        } finally {
            returnJedis(client);
        }
    }

    //根据键值获取value
    public Object hashGet(String key, String field) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            byte[] fieldBytes = serializer.serializeKey(field);
            byte[] valueBytes = client.hget(keyBytes, fieldBytes);
            return serializer.deserializeValue(valueBytes);
        } finally {
            returnJedis(client);
        }

    }

    public void hashSet(String key, String field, Object value) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            byte[] fieldBytes = serializer.serializeKey(field);
            byte[] valueBytes = serializer.serializeValue(value);
            client.hset(keyBytes, fieldBytes, valueBytes);
        } finally {
            returnJedis(client);
        }

    }


    public Map<String, Object> hashAllGet(String key) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            Map<byte[], byte[]> map = client.hgetAll(keyBytes);
            Map<String, Object> valueMap = Maps.newHashMap();
            Set<Map.Entry<byte[], byte[]>> valueSet = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry : valueSet) {
                valueMap.put(serializer.deserializeKey(entry.getKey()), serializer.deserializeValue(entry.getValue()));
            }
            return valueMap;
        } finally {
            returnJedis(client);
        }

    }

    //判断key是否存在
    public boolean existKey(String key) {
        Jedis client = getJedis();
        try {
            byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
            return client.exists(keyBytes);
        } finally {
            returnJedis(client);
        }
    }


}
