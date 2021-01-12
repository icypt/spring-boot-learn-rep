package com.icypt.sboot.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {
    public static String  objToStr(Object obj) {
        return JSON.toJSONString(obj);
    }
}
