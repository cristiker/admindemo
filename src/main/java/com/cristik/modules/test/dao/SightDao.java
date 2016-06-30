package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.Sight;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface SightDao extends Mapper<Sight> {

    List<Sight> queryPage(Map map);

    Integer queryCount(Map map);
}