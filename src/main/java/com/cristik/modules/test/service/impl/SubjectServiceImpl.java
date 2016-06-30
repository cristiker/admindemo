package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.SubjectDao;
import com.cristik.modules.test.entity.svo.Subject;
import com.cristik.modules.test.service.ISubjectService;
import com.cristik.common.base.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/12.
 */

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    SubjectDao subjectDao;

    /**
     * 分页查询主题数据
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        Subject subject = (Subject) pageInfo.getParam();
        Map map = new HashMap();
        map.put("subject",subject);
        map.put("start", pageInfo.getStart());
        map.put("length", pageInfo.getLength());
        List<Subject> list =  subjectDao.queryPage(map);
        Integer count = subjectDao.queryCount(map);
        pageInfo.setData(list);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    /**
     * 增加主题
     * @param subject
     * @return
     */
    @Override
    public boolean insert(Subject subject) {
        subject.setCreateTime(new Date());
        subject.setUpdateTime(new Date());
        int num = subjectDao.insert(subject);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 停用主题
     * @param id
     * @return
     */
    @Override
    public boolean lock(Integer id) {
        Subject subject = new Subject();
        subject.setStatus(1);
        subject.setId(id);
        boolean flag = update(subject);
        return flag;
    }

    /**
     * 启用主题
     * @param id
     * @return
     */
    @Override
    public boolean unLock(Integer id) {
        Subject subject = new Subject();
        subject.setId(id);
        subject.setStatus(2);
        boolean flag = update(subject);
        return flag;
    }

    /**
     * 修改主题
     * @param subject
     * @return
     */
    @Override
    public boolean update(Subject subject) {
        subject.setUpdateTime(new Date());
        int num = subjectDao.updateByPrimaryKeySelective(subject);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据id查找主题
     * @param id
     * @return
     */
    @Override
    public Subject getSubjectById(Integer id) {
        Subject subject = new Subject();
        subject.setId(id);
        subject = subjectDao.selectOne(subject);
        return subject;
    }
}
