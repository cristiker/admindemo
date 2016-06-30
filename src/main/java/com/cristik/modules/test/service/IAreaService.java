package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Area;
import com.cristik.common.base.PageInfo;

import java.util.List;

/**
 * Created by zhenghua on 2016/5/12.
 */
public interface IAreaService {

    PageInfo querydata(PageInfo pageInfo);//分页查询区域信息

    boolean insert(Area area);//增加区域信息

    List<Area> getStates();//查询大洲列表

    List<Area> search(Area area);//查找符合条件的区域



}
