package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.UserLoginDao;
import com.cristik.modules.test.entity.svo.Token;
import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.modules.test.service.ITokenService;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.exception.BusinessException;
import com.cristik.common.utils.IdUtil;
import com.cristik.common.utils.PasswordUtil;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhenghua on 2016/4/26.
 */

@Service
@Transactional
public class UserLoginServiceImpl implements IUserLoginService{
    @Autowired
    UserLoginDao userLoginDao;

    @Autowired
    ITokenService tokenService;

    /**
     * 增加登录用户
     * @param userLogin
     * @return
     */
    @Override
    public boolean insert(UserLogin userLogin) throws BusinessException {
        PasswordUtil.encryptPasswordBySimpleHash(userLogin);
        userLogin.setCreateTime(new Date());
        userLogin.setUpdateTime(new Date());
        userLogin.setStatus(1);
        int num = userLoginDao.insert(userLogin);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据主键删除用户
     * @param userLoginId
     * @return
     */
    @Override
    public boolean deleteUserLoginById(Integer userLoginId) {
        int num = userLoginDao.deleteByPrimaryKey(userLoginId);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 校验用户名是否占用
     * @param loginName
     * @return
     */
    @Override
    public boolean checkLoginName(String loginName) {
        UserLogin userLogin = new UserLogin();
        userLogin.setLoginName(loginName);
        List<UserLogin> list = userLoginDao.select(userLogin);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 校验邮箱是否占用
     * @param email
     * @return
     */
    @Override
    public boolean checkEmail(String email) {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(email);
        List<UserLogin> list = userLoginDao.select(userLogin);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 给用户增加角色
     * @param userLoginId
     * @param roleIds
     */
    @Override
    public void addRelatedRoles(Integer userLoginId, Integer... roleIds) {

    }

    /**
     * 用户删除角色
     * @param userLoginId
     * @param roleIds
     */
    @Override
    public void removeRelatedRoles(Long userLoginId, Integer... roleIds) {

    }

    /**
     * 根据登录名查找用户
     * @param loginName
     * @return
     */
    @Override
    public UserLogin findByUsername(String loginName) {
        UserLogin userLogin = new UserLogin();
        userLogin.setLoginName(loginName);
        List<UserLogin> list = userLoginDao.select(userLogin);
        if(list!=null&&list.size()==1){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 根据用户名查找角色
     * @param username
     * @return
     */
    @Override
    public Set<String> findRoles(String username) {
        Set<String> roles = userLoginDao.findRoles(username);
        return roles;
    }

    /**
     * 根据用户名冻结账户
     * @param userName
     * @return
     */
    @Override
    public boolean lockUserByName(String userName) {
        UserLogin userLogin = new UserLogin();
        userLogin.setLoginName(userName);
        userLogin.setStatus(2);
        Integer num = userLoginDao.updateStatusByLoginName(userLogin);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据用户名解禁账户
     * @param userName
     * @return
     */
    @Override
    public boolean unLockUserByName(String userName) {
        UserLogin userLogin = new UserLogin();
        userLogin.setLoginName(userName);
        userLogin.setStatus(1);
        Integer num = userLoginDao.updateStatusByLoginName(userLogin);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据用户名查找权限
     * @param userName
     * @return
     */
    @Override
    public Set<String> findPermissions(String userName) {
        UserLogin userLogin = new UserLogin();
        return null;
    }

    /**
     * 用户认证并返回token
     * @param loginName
     * @return
     */
    @Override
    public Token authenticate(String loginName){
        UserLogin login = findByUsername(loginName);
        if(login == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(login.getStatus()==2) {
            throw new LockedAccountException(); //帐号锁定
        }else{
            Token token = new Token();
            Date date = new Date();
            Date expTime = new Date(date.getTime()+(long)60*60*1000);
            token.setToken(IdUtil.getId());
            token.setExpTime(expTime);
            token.setUserId(login.getId());
            token.setUserType(login.getType());
            boolean flag = tokenService.insert(token);
            if(flag){
                return token;
            }else{
                return null;
            }
        }
    }

    @Override
    public boolean clearToken(String token) {
        Token token1 = new Token();
        token1.setToken(token);
        return tokenService.deleteToken(token1);
    }


    @Override
    public UserLogin findByUserId(Integer userId) {
        UserLogin userLogin = new UserLogin();
        userLogin.setId(userId);
        userLogin = userLoginDao.selectOne(userLogin);
        return userLogin;
    }


}
