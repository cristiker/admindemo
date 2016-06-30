package com.cristik.pattern.adapter.controller;

import com.cristik.pattern.adapter.Controller;

/**
 * @Package: com.cristik.pattern.adapter.controllerimpl.HttpController
 * @ClassName: HttpController.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:22
 * @Version: v1.0
 */
public class HttpController implements Controller {

    public void doHttpHandler(){
        System.out.println("http...");
    }

}
