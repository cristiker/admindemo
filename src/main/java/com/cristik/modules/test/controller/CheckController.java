package com.cristik.modules.test.controller;

import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/5/5.
 */

@Controller
@RequestMapping("/check")
public class CheckController extends BaseController {
    protected static Logger logger = Logger.getLogger(Controller.class);

    @Autowired
    private IUserLoginService userLoginService;

    /**
     * 校验用户名是否可用
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkloginname")
    public String checkUserName(String userName){
        boolean flag = userLoginService.checkLoginName(userName);
        if(flag){
            return error("已被占用");
        }else{
            return success("可以使用");
        }
    }

    /**
     * 校验邮箱是否可用
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkemail")
    public String checkEmail(String email){
        boolean flag = userLoginService.checkEmail(email);
        if(flag){
            return error("已被占用");
        }else{
            return success("可以使用");
        }
    }
}
