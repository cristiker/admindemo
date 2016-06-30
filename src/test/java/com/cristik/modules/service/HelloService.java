package com.cristik.modules.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/3/31.
 */
@Service("helloService")
public class HelloService {
    @Cacheable(value="statuscache",key = "#name+#age",condition="'Joshua'.equals(#name)||'Josh'.equals(#name)")
    public String getMessage(String name,String age) {
        System.out.println("Executing HelloServiceImpl" +
                ".getHelloMessage(\"" + name + "\")");
        return "Hello " + name + "is "+age+" year old!";
    }
}
