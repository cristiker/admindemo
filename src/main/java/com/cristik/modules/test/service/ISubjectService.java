package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Subject;
import com.cristik.common.base.PageInfo;

/**
 * Created by zhenghua on 2016/5/12.
 */
public interface ISubjectService {

    PageInfo queryPage(PageInfo pageInfo);//分页查询数据

    boolean insert(Subject subject);//新增主题

    boolean lock(Integer id);//停用主题

    boolean unLock(Integer id);//启用主题

    boolean update(Subject subject);//修改主题

    Subject getSubjectById(Integer id);//根据id查询主题





}
