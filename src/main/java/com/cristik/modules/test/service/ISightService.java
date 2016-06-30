package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Sight;
import com.cristik.common.base.PageInfo;

/**
 * Created by zhenghua on 2016/5/16.
 */
public interface ISightService {

    PageInfo queryPage(PageInfo pageInfo);//分页查询景点列表

    Sight getSightById(Integer id);//根据主键查找景点

    boolean update(Sight sight);//修改景点信息

    boolean insert(Sight sight);//增加景点

    boolean verify(Integer id);//通过景点审核

    boolean reject(Integer id);//拒绝景点
}
