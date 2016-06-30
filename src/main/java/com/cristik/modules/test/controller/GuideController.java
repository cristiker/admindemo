package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Guide;
import com.cristik.modules.test.service.IGuideService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/5/5.
 */
@Controller
@RequestMapping("/guide")
public class GuideController extends BaseController{
    @Autowired
    IGuideService guideService;

    /**
     * 跳转到导游列表页面
     * @return
     */
    @RequestMapping("/list")
    public String getGuidePage(ModelMap model,String menu){
        model.put("menu",menu);
        return "guide/guidelist";
    }

    /**
     * 分页查询数据
     * @param pageInfo
     * @param guide
     * @return
     */
    @ResponseBody
    @RequestMapping("/querydata")
    public String queryData(PageInfo pageInfo,Guide guide){
        pageInfo.setParam(guide);
        pageInfo = guideService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    /**
     * 查询向导详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public String showDetail(ModelMap model,Integer id){
        Guide guide = guideService.getGuideById(id);
        model.put("guide",guide);
        return "guide/guidedetail";
    }

    /**
     * 向导信息审核页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/toverify")
    public String toVerify(ModelMap model,Integer id){
        Guide guide = guideService.getGuideById(id);
        model.put("guide",guide);
        return "guide/guideverify";
    }

    /**
     *  禁用向导
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/lock")
    public String lock(Integer id){
        boolean flag = guideService.lock(id);
        if(flag){
            return success("已禁用");
        }else{
            return error("系统异常禁用失败");
        }
    }

    /**
     * 解禁向导
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/unlock")
    public String unLock(Integer id){
        boolean flag = guideService.unLock(id);
        if(flag){
            return success("已解禁");
        }else{
            return error("系统异常解禁失败");
        }
    }

    /**
     * 审核向导通过
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/review")
    public String review(Integer id){
        boolean flag = guideService.review(id);
        if(flag){
            return success("已通过");
        }else{
            return error("系统异常审核失败");
        }
    }

    /**
     * 拒绝向导申请
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/reject")
    public String reject(Integer id){
        boolean flag = guideService.reject(id);
        if(flag){
            return success("申请已拒绝");
        }else{
            return error("系统异常");
        }
    }





}
