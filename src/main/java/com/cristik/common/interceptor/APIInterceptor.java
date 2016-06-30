package com.cristik.common.interceptor;

import com.cristik.modules.test.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhenghua on 2016/4/22.
 */
@Component
public class APIInterceptor implements HandlerInterceptor{

    @Autowired
    ITokenService tokenService;

    /**
     * 用户认证
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String authorization = request.getHeader("Authorization");
        String tokenStr = "";
        if(StringUtils.isNotBlank(authorization)&&authorization.startsWith("Bearer ")){
            tokenStr = authorization.substring(7);
        }
        if(tokenStr==""){
            throw new BusinessException("请先登录");
        }else{
            Token token  = tokenService.getToken(tokenStr);
            if(token==null){
                throw new BusinessException("请重新登录");
            }else{
                if(token.getExpTime().after(new Date())){
                    return true;
                }else{
                    throw new BusinessException("token已失效请重新验证");
                }
            }

        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
