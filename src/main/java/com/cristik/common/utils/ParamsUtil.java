package com.cristik.common.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhenghua on 2016/3/23.
 */
public class ParamsUtil {
    public static String storeParams(HttpServletRequest request) throws UnsupportedEncodingException {
        //请求根路径
        String context = request.getContextPath();
        //请求的url
        String uri = request.getRequestURI();
        //请求的Mapper路径
        String url = StringUtils.substring(uri, context.length());
        String condition = "";
        Map map = request.getParameterMap();
        //遍历请求参数并拼接
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            for (String value : values) {
                if (condition.length() != 0) {
                    condition += "&" + key + "=" + value;
                } else {
                    condition += "?" + key + "=" + value;
                }
            }
        }
        String params = URLEncoder.encode(url+condition, "utf-8");
        return params;
    }
}
