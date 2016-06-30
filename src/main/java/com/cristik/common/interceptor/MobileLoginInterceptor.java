package com.cristik.common.interceptor;

import com.cristik.common.base.SessionHelper;
import com.cristik.common.exception.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhenghua on 2016/3/23.
 */
public class MobileLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否是手机api的请求路径
        if (StringUtils.substring(request.getRequestURI(), request.getContextPath().length()).startsWith("/api")) {
            if (SessionHelper.isVisitorLogin()) {
                return true;
            } else {
                throw new BusinessException("游客未登录");
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
