package com.cristik.common.base;

import com.cristik.modules.test.entity.svo.User;
import com.cristik.modules.test.entity.svo.Visitor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhenghua on 2016/3/22.
 */
public class SessionHelper {

    public static HttpSession getSession(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static void putUser(User user){
        HttpSession session = getSession();
        session.setAttribute("user",user);
    }

    public static User getUser(){
        HttpSession session = getSession();
        return (User)session.getAttribute("user");
    }

    public static void removeUser(){
        HttpSession session = getSession();
        session.removeAttribute("user");
    }

    public static void putVisitor(Visitor visitor){
        HttpSession session = getSession();
        session.setAttribute("visitor",visitor);
    }

    public static Visitor getVisitor(){
        HttpSession session = getSession();
        return (Visitor)session.getAttribute("visitor");
    }

    public static void removeVisitor(){
        HttpSession session = getSession();
        session.removeAttribute("visitor");
    }

    public static boolean isUserLogin(){
        HttpSession session = getSession();
        System.out.println(session.getId());
        Object obj = session.getAttribute("user");
        if(obj!=null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isVisitorLogin(){
        HttpSession session = getSession();
        Object obj = session.getAttribute("visitor");
        if(obj!=null){
            return true;
        }else{
            return false;
        }
    }

}
