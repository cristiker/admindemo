package com.cristik.pattern.adapter.controller;

import com.cristik.pattern.adapter.Controller;

/**
 * @Package: com.cristik.pattern.adapter.controllerimpl.SimpleController
 * @ClassName: SimpleController.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:23
 * @Version: v1.0
 */
public class SimpleController implements Controller {

    public void doSimplerHandler(){
        System.out.println("simple...");
    }

}
