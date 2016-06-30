package com.cristik.pattern.adapter;

/**
 * @Package: com.cristik.pattern.adapter.HandlerAdapter
 * @ClassName: HandlerAdapter.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 13:20
 * @Version: v1.0
 */
public interface HandlerAdapter {

    public boolean supports(Object handler);

    public void handle(Object handler);

}
