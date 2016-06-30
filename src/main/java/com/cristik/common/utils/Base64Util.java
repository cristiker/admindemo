package com.cristik.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by zhenghua on 2016/3/21.
 */
public class Base64Util {
    /**
     * 解密
     * @param key
     * @return
     * @throws IOException
     */
    public static byte[] decryptBASE64(String key) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * 加密
     * @param key
     * @return
     */
    public static String encryptBASE64(byte[] key){
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
