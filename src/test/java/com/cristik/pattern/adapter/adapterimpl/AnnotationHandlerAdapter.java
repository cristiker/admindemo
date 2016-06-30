package com.cristik.pattern.adapter.adapterimpl;

import com.cristik.pattern.adapter.HandlerAdapter;
import com.cristik.pattern.adapter.controller.AnnotationController;

/**
 * @Package: com.cristik.pattern.adapter.adapterimpl.AnnotationHandlerAdapter
 * @ClassName: AnnotationHandlerAdapter.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:35
 * @Version: v1.0
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }
}
