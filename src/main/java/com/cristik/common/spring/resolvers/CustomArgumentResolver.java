package com.cristik.common.spring.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Package: com.cristik.framework.spring.resolvers.CustomArgumentResolver
 * @ClassName: CustomArgumentResolver.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/24 17:29
 * @Version: v1.0
 */
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println(111111);
        return null;
    }
}
