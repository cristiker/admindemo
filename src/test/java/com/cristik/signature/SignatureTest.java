package com.cristik.signature;

import com.cristik.common.utils.WeixinMessageDigest;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhenghua on 2016/3/23.
 */
public class SignatureTest {

    public static void main(String[] args) throws IOException {
        String SecretId="AKIDz8krbsJ5yKBZQpn74WFkmLPx3gnPhESA";
        String SecretKey="Gu5t9xGARNpq86cd98joQYCN3Cozk1qA";
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Action","DescribeInstances");
        map.put("Nonce","345122");
        map.put("Region","gz");
        map.put("SecretId",SecretId);
        map.put("Timestamp","1408704141");
        map.put("instanceIds.0","qcvm12345");
        map.put("instanceIds.1","qcvm56789");
        String signature = WeixinMessageDigest.getSignature(map,SecretKey);
    }

    @Test
    public void testMd5AndMd5Hex(){
        byte[] bytes = DigestUtils.md5("123456");
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        System.out.println(sign);

        String b = DigestUtils.md5Hex("123456");
        System.out.println(b);
    }

    @Test
    public void testBase64(){
        String username = "cristik@163.com";
        String password = "zhenghua3700217";
        System.out.println(Base64.encode(username.getBytes()));
        System.out.println(Base64.encode(password.getBytes()));
    }

}
