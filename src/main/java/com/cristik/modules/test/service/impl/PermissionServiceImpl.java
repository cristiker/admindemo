package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.PermissionDao;
import com.cristik.modules.test.entity.svo.Permission;
import com.cristik.modules.test.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhenghua on 2016/4/26.
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionDao permissionDao;

    @Override
    public boolean insert(Permission permission) {
        int num = permissionDao.insert(permission);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletePermissionById(Long permissionId) {
        int num = permissionDao.deleteByPrimaryKey(permissionId);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

}
