package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Visitor;
import com.cristik.modules.test.service.IVisitorService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import com.cristik.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/4/20.
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController extends BaseController{
    @Autowired  IVisitorService visitorService;


    @RequestMapping("/list")
    public String visitorList(ModelMap model, String menu){
        model.put("menu",menu);
        return "visitor/visitorlist";
    }

    @ResponseBody
    @RequestMapping("/querydata")
    public String getVisitorList(PageInfo pageInfo,Visitor visitor) throws BusinessException {
        pageInfo.setParam(visitor);
        pageInfo = visitorService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    @RequestMapping("/detail")
    public String showDetail(ModelMap model,Integer id){
        Visitor visitor = visitorService.getVisitorById(id);
        model.put("visitor",visitor);
        return "visitor/visitordetail";
    }

}
