package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.mvo.DestinationMVO;
import com.cristik.modules.test.entity.svo.Destination;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface DestinationDao extends Mapper<Destination> {

    List<DestinationMVO> queryPage(Map map);

    Integer queryCount(Map map);

    DestinationMVO getDestinationById(Integer id);
}