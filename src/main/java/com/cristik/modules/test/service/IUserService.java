package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.mvo.UserMVO;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.common.base.PageInfo;
import com.cristik.common.exception.BusinessException;

import java.util.List;

/**
 * Created by zhenghua on 2016/4/20.
 */
public interface IUserService {

    boolean insert(UserMVO userMVO) throws BusinessException;//增加新的用户

    User getUserById(Integer id);//根据id查找用户

    boolean deleteUser(Integer id);//根据id删除用户

    boolean updateUser(User user);//更新用户信息

    boolean lockUser(User user);//冻结用户

    boolean unLockUser(User user);//解禁用户

    PageInfo queryPage(PageInfo pageInfo);//分页查询用户信息

    User queryUserByUserName(String userName);//查询用户信息

    List<User> search(User user);//查询提示

}
