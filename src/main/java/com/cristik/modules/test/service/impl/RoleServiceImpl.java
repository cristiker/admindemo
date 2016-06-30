package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.RoleDao;
import com.cristik.modules.test.entity.svo.Role;
import com.cristik.modules.test.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zhenghua on 2016/4/26.
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    @Autowired
    RoleDao roleDao;

    /**
     * 新增角色
     * @param role
     * @return
     */
    @Override
    public boolean insert(Role role) {
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        int num = roleDao.insert(role);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据主键删除角色
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteRoleById(Integer roleId) {
        int num = roleDao.deleteByPrimaryKey(roleId);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 角色增加权限
     * @param roleId
     * @param permissionIds
     * @return
     */
    @Override
    public boolean addRelatedPermissions(Integer roleId, Long... permissionIds) {
        return false;

    }

    /**
     * 角色删除权限
     * @param roleId
     * @param permissionIds
     * @return
     */
    @Override
    public boolean removeRelatedPermissions(Integer roleId, Long... permissionIds) {
        return false;
    }
}
