package com.cristik.pattern.adapter.adapterimpl;

import com.cristik.pattern.adapter.HandlerAdapter;
import com.cristik.pattern.adapter.controller.SimpleController;

/**
 * @Package: com.cristik.pattern.adapter.adapterimpl.SimpleHandlerAdapter
 * @ClassName: SimpleHandlerAdapter.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:27
 * @Version: v1.0
 */
public class SimpleHandlerAdapter implements HandlerAdapter {


    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }

    @Override
    public void handle(Object handler) {
        ((SimpleController)handler).doSimplerHandler();
    }
}
