package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.GuideDao;
import com.cristik.modules.test.entity.svo.Guide;
import com.cristik.modules.test.service.IGuideService;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/5.
 */
@Service
@Transactional
public class GuideServiceImpl implements IGuideService{
    @Autowired
    GuideDao guideDao;

    @Autowired
    IUserLoginService userLoginService;

    /**
     * 分页查询列表
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        Guide guide = (Guide) pageInfo.getParam();
        Map map = new HashMap<String,Object>();
        map.put("guide",guide);
        map.put("start",pageInfo.getStart());
        map.put("length", pageInfo.getLength());
        List<Guide> list = guideDao.queryPage(map);
        pageInfo.setData(list);
        Integer count = guideDao.queryCount(map);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @Override
    public Guide getGuideById(Integer id) {
        Guide guide = new Guide();
        guide.setId(id);
        guide = guideDao.selectOne(guide);
        return guide;
    }

    @Override
    public boolean lock(Integer id) {
        //修改状态
        Guide guide = new Guide();
        guide.setId(id);
        guide = guideDao.selectOne(guide);
        guide.setStatus(2);
        boolean flag1 = updateGuide(guide);
        boolean flag2 = userLoginService.lockUserByName(guide.getUserName());
        return flag1&&flag2;
    }

    @Override
    public boolean unLock(Integer id) {
        //修改状态
        Guide guide = new Guide();
        guide.setId(id);
        guide = guideDao.selectOne(guide);
        guide.setStatus(1);
        boolean flag1 = updateGuide(guide);
        boolean flag2 = userLoginService.unLockUserByName(guide.getUserName());
        return flag1&&flag2;
    }

    //审核通过
    @Override
    public boolean review(Integer id) {
        return unLock(id);
    }

    @Override
    public boolean reject(Integer id) {
        //修改状态
        Guide guide = new Guide();
        guide.setId(id);
        guide = guideDao.selectOne(guide);
        guide.setStatus(3);
        boolean flag1 = updateGuide(guide);
        boolean flag2 = userLoginService.lockUserByName(guide.getUserName());
        return flag1&&flag2;
    }

    /**
     * 更新向导资料
     * @param guide
     * @return
     */
    @Override
    public boolean updateGuide(Guide guide) {
        guide.setUpdateTime(new Date());
        int num = guideDao.updateByPrimaryKeySelective(guide);

        if(num==1){
            return true;
        }else{
            return false;
        }
    }
}
