package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Subject;
import com.cristik.modules.test.service.ISubjectService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenghua on 2016/5/12.
 */

@Controller
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    @Autowired
    ISubjectService subjectService;

    /**
     * 主题列表管理页面
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping("/list")
    public String getSubjectListByPage(ModelMap model,String menu){
        model.put("menu",menu);
        return "subject/subjectlist";
    }

    /**
     * 异步分页查询主题列表
     * @param pageInfo
     * @param subject
     * @return
     */
    @ResponseBody
    @RequestMapping("/querydata")
    public String queryData(PageInfo pageInfo, Subject subject){
        pageInfo.setParam(subject);
        pageInfo = subjectService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    /**
     * 跳转到主题增加页面
     * @return
     */
    @RequestMapping(value = "/addsubject",method = RequestMethod.GET )
    public String addSubject(){
        return "subject/addsubject";
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping(value="/updatesubject",method = RequestMethod.GET)
    public String updateSubject(Integer id,ModelMap model){
        Subject subject = subjectService.getSubjectById(id);
        model.put("subject",subject);
        return "subject/updatesubject";
    }

    /**
     * 修改主题
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updatesubject",method = RequestMethod.POST)
    public String update(Subject subject){
        boolean flag = subjectService.update(subject);
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
        Subject subject = subjectService.getSubjectById(id);
        model.put("subject",subject);
        return "subject/subjectdetail";
    }


    /**
     * 增加主题功能
     * @param subject
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/addsubject",method = RequestMethod.POST)
    public String insert(Subject subject){
        boolean flag = subjectService.insert(subject);
        if(flag){
            return success("主题增加成功");

        }else{
            return error("主题增加失败");
        }
    }


    /**
     * 停用主题
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/lock")
    public String lock(Integer id){
        boolean flag = subjectService.lock(id);
        if(flag){
            return success("已停用");
        }else{
            return error("停用失败");
        }
    }

    /**
     * 启用主题
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/unlock")
    public String unLock(Integer id){
        boolean flag = subjectService.unLock(id);
        if(flag){
            return success("已启用");
        }else{
            return error("启用失败");
        }
    }


}
