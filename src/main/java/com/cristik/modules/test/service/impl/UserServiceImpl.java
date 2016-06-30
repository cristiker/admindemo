package com.cristik.modules.test.service.impl;


import com.cristik.modules.test.dao.UserDao;
import com.cristik.modules.test.entity.mvo.UserMVO;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.modules.test.service.IUserService;
import com.cristik.common.base.PageInfo;
import com.cristik.common.base.SessionHelper;
import com.cristik.common.exception.BusinessException;
import com.cristik.common.utils.ObjectPropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhenghua on 2016/3/10.
 */
@Service
@Transactional(readOnly = false,rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService{
    @Autowired
    UserDao userDao;

    @Autowired
    IUserLoginService userLoginService;

    /**
     * 根据主键查用户
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user = userDao.selectOne(user);
        return user;
    }

    /**
     * 分页查询用户信息
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo queryPage(PageInfo pageInfo) {
        User user = (User)pageInfo.getParam();
        Map map = new HashMap<String,Object>();
        map.put("user",user);
        map.put("start", pageInfo.getStart());
        map.put("length", pageInfo.getLength());
        List<User> list =  userDao.queryPage(map);
        Integer count = userDao.queryCount(map);
        pageInfo.setData(list);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        return pageInfo;
    }

    @Override
    public User queryUserByUserName(String userName) {
        User user = new User();
        user.setUserName(userName);
        List<User> list = userDao.select(user);
        if(list.size()==1){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<User> search(User user) {
        List<User> list = userDao.search(user);
        return list;
    }


    /**
     * 新增用户
     * @param userMVO
     * @return
     * @throws BusinessException
     */
    public boolean insert(UserMVO userMVO) throws BusinessException {
        User user = new User();
        ObjectPropertyUtil.copyProperty(userMVO,user);
        if(userLoginService.checkLoginName(userMVO.getUserName())){
            throw new BusinessException("用户已被注册");
        }
        user.setStatus(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        UserLogin userLogin = new UserLogin();
        //如果user中不包含密码设置默认密码为123456
        if(userMVO.getPassword()!=null&&userMVO.getPassword()!=""){
            userLogin.setPassword(userMVO.getPassword());
        }else{
            userLogin.setPassword("123456");
        }
        userLogin.setLoginName(user.getUserName());
        userLoginService.insert(userLogin);
        int id = userDao.insert(user);
        if (id == 1) {
            SessionHelper.putUser(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户退出
     * @return
     */
    public boolean logout(){
        SessionHelper.removeUser();
        return true;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteUser(Integer id) {
        Integer num = userDao.deleteByPrimaryKey(id);
        boolean flag = false;
        if (num.intValue() == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        user.setUpdateTime(new Date());
        int num = userDao.updateByPrimaryKeySelective(user);
        boolean flag = false;
        if (num == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean lockUser(User user) {
        User userLogin = userDao.selectOne(user);
        user.setStatus(2);
        boolean flag = updateUser(user);
        boolean flag2 = userLoginService.lockUserByName(userLogin.getUserName());
        return flag&&flag2;
    }

    @Override
    public boolean unLockUser(User user) {
        User userLogin = userDao.selectOne(user);
        user.setStatus(1);
        boolean flag = updateUser(user);
        boolean flag2 = userLoginService.unLockUserByName(userLogin.getUserName());
        return flag&&flag2;
    }

}
