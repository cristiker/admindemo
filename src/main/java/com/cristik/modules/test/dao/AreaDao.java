package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.Area;
import java.util.List;
import java.util.Map;

import com.cristik.modules.test.entity.svo.User;
import tk.mybatis.mapper.common.Mapper;

public interface AreaDao extends Mapper<Area> {

    List<User> queryPage(Map map);

    Integer queryCount(Map map);

}