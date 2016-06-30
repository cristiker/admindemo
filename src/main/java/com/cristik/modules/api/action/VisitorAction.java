package com.cristik.modules.api.action;

import com.cristik.modules.test.entity.svo.Visitor;
import com.cristik.modules.test.service.IVisitorService;
import com.cristik.common.base.BaseAction;
import com.cristik.common.base.SessionHelper;
import com.cristik.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/4/21.
 */
@Controller
@RequestMapping("/api/visitor")
public class VisitorAction extends BaseAction{
    @Autowired
    IVisitorService visitorService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody Visitor visitor) throws BusinessException {
        boolean flag = visitorService.insert(visitor);
        if(flag){
            return success("注册成功");
        }else{
            return error("注册失败");
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody Visitor visitor)throws BusinessException{
        boolean flag = visitorService.login(visitor);
        if(flag){
            return success("登录成功");
        }else{
            return error("登录失败");
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        SessionHelper.removeVisitor();
        return success("退出成功");
    }

    @RequestMapping("/profile")
    @ResponseBody
    public String visitorProfile(){
        Visitor visitor  = SessionHelper.getVisitor();

        return success("");
    }




    public String checkUserName(){
        return "";
    }

    public String checkEmail(){
        return "";
    }

    public String checkPhone(){
        return "";
    }


}
