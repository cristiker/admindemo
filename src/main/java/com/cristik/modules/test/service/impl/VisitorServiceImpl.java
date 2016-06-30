package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.VisitorDao;
import com.cristik.modules.test.entity.svo.Visitor;
import com.cristik.modules.test.service.IVisitorService;
import com.cristik.common.base.PageInfo;
import com.cristik.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/4/20.
 */

@Service
@Transactional
public class VisitorServiceImpl implements IVisitorService{
    @Autowired
    VisitorDao visitorDao;


    /**
     * 查询
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo queryVerifyVisitors(PageInfo pageInfo) {
        return pageInfo;
    }

    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        Map map = new HashMap<String,Object>();
        Visitor visitor = (Visitor) pageInfo.getParam();
        visitor.setStatus(1);
        map.put("visitor",visitor);
        map.put("start", pageInfo.getStart());
        map.put("length", pageInfo.getLength());
        Integer count = visitorDao.queryCount(map);
        List<Visitor> list = visitorDao.queryPage(map);
        pageInfo.setData(list);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setRecordsTotal(count);
        return pageInfo;
    }


    /**
     * 新增游客
     * @param visitor
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean insert(Visitor visitor) throws BusinessException {

        /*String password = visitor.getPassword();
        if(StringUtils.isNotBlank(password)){
            String pwd =  DigestUtils.md5Hex(password.toLowerCase().getBytes());
            visitor.setPassword(pwd);
        }else{
            throw new BusinessException("密码为空");
        }

        visitor.setCreateTime(new Date());
        visitor.setUpdateTime(new Date());

        int num = visitorDao.insert(visitor);
        if(num==1){
            return true;
        }else{
            return false;
        }*/
        return false;
    }

    /**
     * 更新游客资料
     * @param visitor
     * @return
     */
    public boolean update(Visitor visitor){
        int num = visitorDao.updateByPrimaryKeySelective(visitor);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 游客登陆
     * @param visitor
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean login(Visitor visitor) throws BusinessException {
        boolean flag = false;
        /*if(StringUtils.isNotBlank(visitor.getUserName())){
            if(StringUtils.isNotBlank(visitor.getPassword())){
                visitor.setPassword(DigestUtils.md5Hex(visitor.getPassword().getBytes()));
                List<Visitor> list = visitorDao.select(visitor);
                if(list.size()==1){
                    Visitor loginUser = list.get(0);
                    loginUser.setPassword("");
                    SessionHelper.putVisitor(visitor);
                    flag = true;
                }else{
                    throw new BusinessException("密码不存在");
                }
            }else{
                throw new BusinessException("密码为空");
            }
        }else{
            throw new BusinessException("用户名为空");
        }*/
        return flag;
    }

    /**
     * 根据id获取符合条件的游客
     * @param visitor
     * @return
     */
    @Override
    public Visitor getVisitProfiles(Visitor visitor) {
        visitor = visitorDao.selectOne(visitor);
        return visitor;
    }

    /**
     * 根据id获取游客信息
     * @param id
     * @return
     */
    @Override
    public Visitor getVisitorById(Integer id) {
        Visitor visitor = new Visitor();
        visitor.setId(id);
        return getVisitProfiles(visitor);
    }



}
