package com.cristik.pattern.adapter.adapterimpl;

import com.cristik.pattern.adapter.HandlerAdapter;
import com.cristik.pattern.adapter.controller.HttpController;

/**
 * @Package: com.cristik.pattern.adapter.adapterimpl.HttpHandlerAdapter
 * @ClassName: HttpHandlerAdapter.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:32
 * @Version: v1.0
 */
public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}
