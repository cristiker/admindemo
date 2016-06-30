package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.UserLogin;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

public interface UserLoginDao extends Mapper<UserLogin> {

    Integer updateStatusByLoginName(UserLogin userLogin);

    Set<String> findRoles(String username);
}