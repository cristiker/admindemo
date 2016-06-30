package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.Visitor;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface VisitorDao extends Mapper<Visitor> {

    List<Visitor> queryPage(Map map);

    Integer queryCount(Map map);

}