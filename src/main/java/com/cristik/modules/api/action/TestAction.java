package com.cristik.modules.api.action;

import com.cristik.modules.test.entity.svo.User;
import com.cristik.common.base.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhenghua on 2016/3/24.
 */

@Controller
@RequestMapping("/api/test")
public class TestAction extends BaseAction{

    @ResponseBody
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String testMethodPost(@RequestBody User user){
        System.out.println("新增用户");
        return success("新增用户");
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public String testMethodDelete(@PathVariable("id") String id ){
        System.out.println("删除用户");
        return success("删除用户");
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public String testMethodPut(@PathVariable("id") String id , @RequestBody User user){
        System.out.println("修改用户");
        return success("修改用户");
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public String testMethodGet(@PathVariable("id") String id ){
        System.out.println("查询用户");
        return success("查询用户");
    }

}
