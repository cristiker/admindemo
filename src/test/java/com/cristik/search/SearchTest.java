package com.cristik.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by zhenghua on 2016/4/19.
 */
public class SearchTest {

    public static void main(String[] args) {
        try {
            String key = "java"; //查询关键字
            key = URLEncoder.encode(key, "gb2312");
            URL u = new URL("http://www.baidu.com.cn/s?wd=" + key + "&cl=3");
            URLConnection conn = u.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf8"));
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

