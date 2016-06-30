package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.svo.Subject;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface SubjectDao extends Mapper<Subject> {

    List<Subject> queryPage(Map map);

    Integer queryCount(Map map);

}