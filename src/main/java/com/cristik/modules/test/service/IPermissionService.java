package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Permission;

/**
 * Created by zhenghua on 2016/4/26.
 */
public interface IPermissionService {

    boolean insert(Permission permission);//增加权限

    boolean deletePermissionById(Long permissionId);//删除权限
}
