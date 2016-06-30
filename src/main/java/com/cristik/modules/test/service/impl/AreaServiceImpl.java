package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.AreaDao;
import com.cristik.modules.test.entity.svo.Area;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.modules.test.service.IAreaService;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/12.
 */

@Service
@Transactional
public class AreaServiceImpl implements IAreaService {
    @Autowired
    AreaDao areaDao;

    @Override
    public PageInfo querydata(PageInfo pageInfo) {
        Area area = (Area)pageInfo.getParam();
        Map map = new HashMap<String,Object>();
        map.put("area",area);
        map.put("start", pageInfo.getStart());
        map.put("length", pageInfo.getLength());
        List<User> list =  areaDao.queryPage(map);
        Integer count = areaDao.queryCount(map);
        pageInfo.setData(list);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    @Override
    public boolean insert(Area area) {
        int num = areaDao.insert(area);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Area> getStates() {
        Area area = new Area();
        area.setType(1);
        List<Area> areas = areaDao.select(area);
        return areas;
    }

    @Override
    public List<Area> search(Area area) {
        List<Area> areas = areaDao.select(area);
        return areas;
    }


}
