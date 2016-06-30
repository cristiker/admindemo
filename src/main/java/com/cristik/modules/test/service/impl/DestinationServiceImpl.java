package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.DestinationDao;
import com.cristik.modules.test.entity.mvo.DestinationMVO;
import com.cristik.modules.test.entity.svo.Destination;
import com.cristik.modules.test.service.IDestinationService;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/16.
 */
@Transactional
@Service
public class DestinationServiceImpl implements IDestinationService {

    @Autowired
    DestinationDao destinationDao;

    @Override
    public boolean insert(Destination destination) {
        destination.setStatus(1);
        destination.setCreateTime(new Date());
        destination.setUpdateTime(new Date());
        int num = destinationDao.insert(destination);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        int num = destinationDao.deleteByPrimaryKey(id);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(Destination destination) {
        destination.setUpdateTime(new Date());
        int num = destinationDao.updateByPrimaryKeySelective(destination);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public DestinationMVO getDestinationById(Integer id) {
        DestinationMVO destinationMVO = destinationDao.getDestinationById(id);
        return destinationMVO;
    }

    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        DestinationMVO destinationMVO = (DestinationMVO)pageInfo.getParam();
        Map map = new HashMap();
        map.put("start",pageInfo.getStart());
        map.put("length",pageInfo.getLength());
        map.put("destinationMVO",destinationMVO);
        List<DestinationMVO> list =  destinationDao.queryPage(map);
        Integer count = destinationDao.queryCount(map);
        pageInfo.setData(list);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

}
