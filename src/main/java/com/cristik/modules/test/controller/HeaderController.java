package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Header;
import com.cristik.modules.test.service.IHeaderService;
import com.cristik.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/5/18.
 */

@Controller
@RequestMapping("/header")
public class HeaderController extends BaseController{
    @Autowired
    IHeaderService headerService;

    @RequestMapping("/index")
    public String manageHeader(ModelMap model,String menu){
        Header header = headerService.getHeader();
        model.put("obj",header);
        model.put("menu",menu);
        return "header/headerdetail";
    }

    @ResponseBody
    @RequestMapping(value="/updateheader",method = RequestMethod.POST)
    public String update(Header header){
        if(header.getId()!=null){
            boolean flag = headerService.update(header);
            if(flag){
                return success("修改成功");
            }else{
                return error("修改失败");
            }
        }else{
            boolean flag = headerService.insert(header);
            if(flag){
                return success("增加成功");
            }else{
                return error("增加失败");
            }
        }
    }
}
