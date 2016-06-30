package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.HeaderDao;
import com.cristik.modules.test.entity.svo.Header;
import com.cristik.modules.test.service.IHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhenghua on 2016/5/18.
 */

@Service
@Transactional
public class HeaderServiceImpl implements IHeaderService {
    @Autowired
    HeaderDao headerDao;


    /**
     * 查询一条轮播图
     * @return
     */
    @Override
    public Header getHeader() {
        List<Header> list = headerDao.selectAll();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 修改轮播图
     * @param header
     * @return
     */
    @Override
    public boolean update(Header header) {
        header.setUpdateTime(new Date());
        int num = headerDao.updateByPrimaryKeySelective(header);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 新增轮播图
     * @param header
     * @return
     */
    @Override
    public boolean insert(Header header) {
        header.setCreateTime(new Date());
        header.setUpdateTime(new Date());
        int num = headerDao.insert(header);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }
}
