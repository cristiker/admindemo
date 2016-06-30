package com.cristik.modules.api.action;

import com.cristik.modules.test.entity.svo.Token;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.base.BaseAction;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhenghua on 2016/3/18.
 */
@Controller
@RequestMapping("/api/v1")
public class UserLoginAction extends BaseAction{
    @Autowired
    IUserLoginService userLoginService;

    /**
     * 用户认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/tokens")
    public String authenticate(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        String loginName = (String) request.getAttribute("loginName");
        Token token = userLoginService.authenticate(loginName);
        return success("认证成功",token);
    }

    @ResponseBody
    @RequestMapping(value="/cleartoken")
    public String clearToken(String token){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        userLoginService.clearToken(token);
        return success("已删除过期token");
    }
    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/")
    public String logOut(){
        return "";
    }


    @ResponseBody
    @RequestMapping("/checktoken")
    public String checkToken(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        return success("token有效");
    }



}
