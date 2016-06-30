package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.User;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface UserDao extends Mapper<User> {

    List<User> queryPage(Map map);

    Integer queryCount(Map map);

    List<User> search(User user);
}