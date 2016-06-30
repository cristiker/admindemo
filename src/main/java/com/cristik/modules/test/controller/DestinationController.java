package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.mvo.DestinationMVO;
import com.cristik.modules.test.entity.svo.Area;
import com.cristik.modules.test.entity.svo.Destination;
import com.cristik.modules.test.service.IAreaService;
import com.cristik.modules.test.service.IDestinationService;
import com.cristik.common.base.BaseController;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhenghua on 2016/5/16.
 */

@Controller
@RequestMapping("/destination")
public class DestinationController extends BaseController {

    @Autowired
    IDestinationService destinationService;

    @Autowired
    IAreaService areaService;

    /**
     * 跳转到目的地列表页
     * @param model
     * @param menu
     * @return
     */
    @RequestMapping("/list")
    public String getDestinationListByPage(ModelMap model,String menu){
        model.put("menu",menu);
        List<Area> states = areaService.getStates();
        model.put("states",states);
        return "destination/destinationlist";
    }


    /**
     * 异步查询分页数据
     * @param pageInfo
     * @param destination
     * @return
     */
    @ResponseBody
    @RequestMapping("/querydata")
    public String getPage(PageInfo pageInfo, DestinationMVO destination){
        pageInfo.setParam(destination);
        pageInfo = destinationService.queryPage(pageInfo);
        return pageInfo.toJSONString();
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping(value = "/adddestination",method = RequestMethod.GET)
    public String addDestiantion(ModelMap model){
        List<Area> states = areaService.getStates();
        model.put("states",states);
        return "destination/adddestination";
    }

    /**
     * 新增目的地
     * @param destination
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/adddestination",method = RequestMethod.POST)
    public String insert(Destination destination){
        boolean flag = destinationService.insert(destination);
        if(flag){
            return success("新增成功");
        }else{
            return error("新增失败");
        }
    }


    /**
     * 跳转到目的地修改页面
     * @return
     */
    @RequestMapping(value = "/updatedestination",method = RequestMethod.GET)
    public String updateDestination(ModelMap model,Integer id){
        DestinationMVO destinationMVO = destinationService.getDestinationById(id);
        List<Area> states = areaService.getStates();
        model.put("states",states);
        model.put("destinationMVO",destinationMVO);
        return "destination/updatedestination";
    }

    /**
     * 修改目的地
     * @param destination
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatedestination",method = RequestMethod.POST)
    public String update(Destination destination){
        boolean flag = destinationService.update(destination);
        if(flag){
            return success("修改成功");
        }else{
            return error("修改失败");
        }
    }

    /**
     * 查看目的地详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public String showDetail(ModelMap model,Integer id){
        DestinationMVO destinationMVO = destinationService.getDestinationById(id);
        List<Area> states = areaService.getStates();
        model.put("states",states);
        model.put("destinationMVO",destinationMVO);
        return "destination/destinationdetail";
    }







}
