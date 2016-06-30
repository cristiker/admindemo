package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.mvo.UserMVO;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.modules.test.service.IUserService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import com.cristik.common.exception.BusinessException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhenghua on 2016/3/10.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    protected static Logger logger = Logger.getLogger(Controller.class);

    @Autowired
    SessionDAO sessionDAO;

    @Autowired
    IUserService userService;

    @Autowired
    IUserLoginService userLoginService;

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    /**
     * 跳转到新增用户
     * @return
     */
    @RequestMapping("/toregister")
    public String toRegisterUser(){
        return "user/register";
    }

    /**
     * 用户注册
     * @param user
     * @return
     * @throws BusinessException
     */
    @ResponseBody
    @RequestMapping("/adduser")
    public String registerUser(UserMVO user) throws BusinessException {
        userService.insert(user);
        return success("用户注册成功");
    }

    /**
     * 删除用户
     * produces = "text/html;charset=UTF-8"解决返回json中文乱码
     * @param id
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/deleteuser")
    public String deleteUserById(Integer id, ModelMap model) {
        boolean flag = userService.deleteUser(id);
        if (flag) {
            return success("删除成功");

        } else {
            return error("删除失败");
        }
    }

    /**
     * 跳转到修改用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdateuser")
    public String toUpdateUser(Integer id,ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "user/profile";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateuser")
    public String updateUser(User user){
        boolean flag = userService.updateUser(user);
        if(flag){
            return success("修改成功");
        }else{
            return error("修改失败");
        }
    }



    /**
     * 分页查询用户列表
     * @param pageInfo
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/querydata")
    public String getPage(PageInfo pageInfo, User user, HttpServletRequest request){
        pageInfo.setParam(user);
        pageInfo = userService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    /**
     * 管理员列表页面
     * @param model
     * @return
     */
    @RequiresRoles("sale")
    @RequestMapping("/list")
    public String getUserListByPage(ModelMap model,String menu){
        model.put("menu",menu);
        return "user/userlist";
    }

    @ResponseBody
    @RequestMapping("/lock")
    public String lockUser(User user){
        boolean flag = userService.lockUser(user);
        if(flag){
            return success("已冻结");
        }else{
            return error("冻结操作失败");
        }
    }

    @ResponseBody
    @RequestMapping("/unlock")
    public String unLockUser(User user){
        boolean flag = userService.unLockUser(user);
        if(flag){
            return success("已解冻");
        }else{
            return error("解冻操作失败");
        }
    }


    /**
     * 管理员查看自己信息
     * @param model
     * @return
     */
    @RequestMapping("/profile")
    public String userProfile(ModelMap model){
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        User user = userService.queryUserByUserName(userName);
        model.put("user",user);
        return "user/profile";
    }


    /**
     * 查询用户详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String getUserById(Integer id, ModelMap model){
        User user = userService.getUserById(id);
        model.put("user",user);
        return "user/userdetail";
    }

    @ResponseBody
    @RequestMapping("/search")
    public String search(User user){
        List<User> list = userService.search(user);
        return success("查询成功",list);
    }

}
