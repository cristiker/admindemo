package com.cristik.common.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhenghua on 2016/5/12.
 */
public class MenuInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String menu = request.getParameter("menu");
        if(StringUtils.isNotBlank(menu)){
            Cookie cookie = new Cookie("menu",menu);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Cookie[] cookies =  request.getCookies();
        for(Cookie cookie : cookies){
            if("menu".equals(cookie.getName())){
                String value = cookie.getValue();
                if(modelAndView!=null){
                    modelAndView.getModelMap().put("menu",value);
                }
                break;
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
