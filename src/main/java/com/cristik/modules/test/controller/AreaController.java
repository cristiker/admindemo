package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Area;
import com.cristik.modules.test.service.IAreaService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhenghua on 2016/5/12.
 */

@Controller
@RequestMapping("/area")
public class AreaController extends BaseController{

    @Autowired
    IAreaService areaService;

    @RequestMapping("/list")
    public String getAreaList(ModelMap model,String menu){
        model.put("menu",menu);
        return "area/arealist";
    }

    @ResponseBody
    @RequestMapping("/querydata")
    public String getPage(PageInfo pageInfo,Area area){
        pageInfo.setParam(area);
        pageInfo = areaService.querydata(pageInfo);
        return pageInfo.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/addarea")
    public String addArea(Area area){
        boolean flag = areaService.insert(area);
        if(flag){
            return success("增加成功");
        }else{
            return error("增加失败");
        }
    }

    @ResponseBody
    @RequestMapping("/search")
    public String search(Area area){
        List<Area> list = areaService.search(area);
        return success("查询成功",list);
    }



}
