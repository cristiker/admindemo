package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.Guide;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface GuideDao extends Mapper<Guide> {

    List<Guide> queryPage(Map map);

    Integer queryCount(Map map);

}