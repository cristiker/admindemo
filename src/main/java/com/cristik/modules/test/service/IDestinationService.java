package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.mvo.DestinationMVO;
import com.cristik.modules.test.entity.svo.Destination;
import com.cristik.common.base.PageInfo;

/**
 * Created by zhenghua on 2016/5/16.
 */
public interface IDestinationService {

    boolean insert(Destination destination);

    boolean delete(Integer id);

    boolean update(Destination destination);

    DestinationMVO getDestinationById(Integer id);

    PageInfo queryPage(PageInfo pageInfo);//分页查询数据



}
