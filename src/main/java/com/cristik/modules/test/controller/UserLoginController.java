package com.cristik.modules.test.controller;

import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.base.BaseController;
import com.cristik.common.exception.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by zhenghua on 2016/5/3.
 */
@Controller
@RequestMapping("/system")
public class UserLoginController extends BaseController{

    protected static Logger logger = Logger.getLogger(Controller.class);

    @Autowired
    IUserLoginService userLoginService;



    /**
     * 跳转到用户登录
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        String params = request.getParameter("params");
        if(StringUtils.isNotBlank(params)){
            try {
                params = URLDecoder.decode(params,"utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("登录拦截跳转参数异常",e);
            }
        }
        System.out.println(params);
        model.put("url",params);
        return "user/login";
    }

    /**
     * 用户登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public String login(HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("账户不存在");
        }else if(DisabledAccountException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("账户已被禁用");
        }else if(LockedAccountException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("账户已锁定");
        }else if(ExcessiveAttemptsException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("登陆次数失败过多");
        }else if(IncorrectCredentialsException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("凭证错误");
        }else if(ExpiredCredentialsException.class.getName().equalsIgnoreCase(errorClassName)){
            return error("凭证已过期");
        }else{
            return error("系统错误");
        }
    }

    /**
     * 用户登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "user/login";
    }

}
