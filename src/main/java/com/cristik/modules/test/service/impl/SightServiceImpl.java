package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.SightDao;
import com.cristik.modules.test.entity.svo.Sight;
import com.cristik.modules.test.service.ISightService;
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
@Service
@Transactional
public class SightServiceImpl implements ISightService {

    @Autowired
    SightDao sightDao;

    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        Sight sight = (Sight) pageInfo.getParam();
        Map map = new HashMap();
        map.put("start",pageInfo.getStart());
        map.put("length",pageInfo.getLength());
        map.put("sight",sight);
        List<Sight> list = sightDao.queryPage(map);
        Integer count = sightDao.queryCount(map);
        pageInfo.setData(list);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    @Override
    public Sight getSightById(Integer id) {
        Sight sight = new Sight();
        sight.setId(id);
        sight = sightDao.selectOne(sight);
        return sight;
    }

    @Override
    public boolean update(Sight sight) {
        sight.setUpdateTime(new Date());
        int num = sightDao.updateByPrimaryKeySelective(sight);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insert(Sight sight) {
        int num = sightDao.insert(sight);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean verify(Integer id) {
        Sight sight = new Sight();
        sight.setId(id);
        sight.setStatus(2);
        boolean flag = update(sight);
        return flag;
    }

    @Override
    public boolean reject(Integer id) {
        Sight sight = new Sight();
        sight.setId(id);
        sight.setStatus(3);
        boolean flag = update(sight);
        return flag;
    }
}
