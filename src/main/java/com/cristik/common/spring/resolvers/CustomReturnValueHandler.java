package com.cristik.common.spring.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Package: com.cristik.framework.spring.resolvers.CustomReturnValueHandler
 * @ClassName: CustomReturnValueHandler.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/24 17:31
 * @Version: v1.0
 */
public class CustomReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        System.out.println(111);
    }
}
