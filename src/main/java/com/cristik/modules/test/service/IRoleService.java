package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Role;

/**
 * Created by zhenghua on 2016/4/26.
 */
public interface IRoleService {

    boolean insert(Role role);//新增角色

    boolean deleteRoleById(Integer roleId);//根据主键删除角色

    boolean addRelatedPermissions(Integer roleId, Long... permissionIds);//增加角色-权限关系

    boolean removeRelatedPermissions(Integer roleId, Long... permissionIds);//删除角色-权限关系
}
