package com.icypt.learning.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ByteSourceUtils {

    private static Logger logger = LoggerFactory.getLogger(ByteSourceUtils.class);

    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            oos.flush();
            return bos.toByteArray();
        }catch (IOException e) {
            logger.error("序列化错误",e);
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object unSerialize(byte [] bytes) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            Object o = ois.readObject();
            return o;
        } catch (IOException e) {
            logger.error("反序列化错误:IO异常",e);
        } catch (ClassNotFoundException e) {
            logger.error("反序列化错误:类找不到",e);
        }finally {
            try {
                if(bis!=null) {
                    bis.close();
                }
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
