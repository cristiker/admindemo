package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Token;
import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.common.exception.BusinessException;

import java.util.Set;

/**
 * Created by zhenghua on 2016/4/26.
 */
public interface IUserLoginService {

    boolean insert(UserLogin userLogin) throws BusinessException;//新增登录用户

    boolean deleteUserLoginById(Integer userLoginId);//删除登录用户

    boolean checkLoginName(String loginName);//检查用户名是否被占用

    boolean checkEmail(String email);//检查邮箱是否被注册

    void addRelatedRoles(Integer userLoginId, Integer... roleIds); //添加用户-角色关系

    void removeRelatedRoles(Long userLoginId, Integer... roleIds);// 移除用户-角色关系

    UserLogin findByUsername(String loginName);// 根据用户名查找用户

    Set<String> findRoles(String username);// 根据用户名查找其角色

    boolean lockUserByName(String userName);//根据用户名冻结用户

    boolean unLockUserByName(String userName);//根据用户名解禁用户

    Set<String> findPermissions(String userName); //根据用户名查找其权限

    Token authenticate(String loginName);//用户认证

    boolean clearToken(String token);//删除token

    UserLogin findByUserId(Integer userId);//根据ID找用户
}
