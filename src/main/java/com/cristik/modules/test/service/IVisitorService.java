package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Visitor;
import com.cristik.common.base.PageInfo;
import com.cristik.common.exception.BusinessException;

/**
 * Created by zhenghua on 2016/4/20.
 */
public interface IVisitorService {

    PageInfo queryVerifyVisitors(PageInfo pageInfo);//待审核游客列表

    PageInfo queryPage(PageInfo pageInfo);//分页查询游客列表

    boolean insert(Visitor visitor) throws BusinessException;//新增游客

    boolean update(Visitor visitor);//更新游客资料

    boolean login(Visitor visitor) throws BusinessException;//游客登录

    Visitor getVisitProfiles(Visitor visitor);//获得用户资料信息

    Visitor getVisitorById(Integer id);//根据id查询游客信息

}
