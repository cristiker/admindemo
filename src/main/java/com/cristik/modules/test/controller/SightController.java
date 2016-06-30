package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Sight;
import com.cristik.modules.test.service.ISightService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/5/16.
 */
@Controller
@RequestMapping("/sight")
public class SightController extends BaseController {

    @Autowired
    ISightService sightService;

    /**
     * 景点列表管理
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping("/list")
    public String getSubjectListByPage(ModelMap model, String menu){
        model.put("menu",menu);
        return "sight/sightlist";
    }

    /**
     * 异步分页查询景点列表
     * @param pageInfo
     * @param sight
     * @return
     */
    @ResponseBody
    @RequestMapping("/querydata")
    public String queryData(PageInfo pageInfo, Sight sight){
        pageInfo.setParam(sight);
        pageInfo = sightService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    /**
     * 跳转到景点增加页面
     * @return
     */
    @RequestMapping(value = "/addsight",method = RequestMethod.GET )
    public String addSight(){
        return "sight/addsight";
    }

    /**
     * 跳转到景点修改页面
     * @return
     */
    @RequestMapping(value="/updatesight",method = RequestMethod.GET)
    public String updateSight(Integer id,ModelMap model){
        Sight sight = sightService.getSightById(id);
        model.put("sight",sight);
        return "sight/updatesight";
    }

    /**
     * 修改景点
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updatesight",method = RequestMethod.POST)
    public String update(Sight sight){
        boolean flag = sightService.update(sight);
        if(flag){
            return success("修改成功");
        }else{
            return error("修改失败");
        }

    }

    /**
     * 跳转到详情页面
     * @return
     */
    @RequestMapping(value="/detail",method = RequestMethod.GET)
    public String detail(ModelMap model,Integer id){
        Sight sight = sightService.getSightById(id);
        model.put("sight",sight);
        return "sight/sightdetail";
    }


    /**
     * 增加景点
     * @param sight
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/addsightt",method = RequestMethod.POST)
    public String insert(Sight sight){
        boolean flag = sightService.insert(sight);
        if(flag){
            return success("景点增加成功");

        }else{
            return error("景点增加失败");
        }
    }


    /**
     * 通过景点审核
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/verify")
    public String verify(Integer id){
        boolean flag = sightService.verify(id);
        if(flag){
            return success("审核通过");
        }else{
            return error("审核失败");
        }
    }

    /**
     * 景点审核拒绝
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/reject")
    public String reject(Integer id){
        boolean flag = sightService.reject(id);
        if(flag){
            return success("审核拒绝");
        }else{
            return error("审核失败");
        }
    }



}
