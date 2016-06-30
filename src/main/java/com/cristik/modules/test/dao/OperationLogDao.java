package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.test.OperationLog;
import tk.mybatis.mapper.common.Mapper;

public interface OperationLogDao extends Mapper<OperationLog> {
    int insertLog(OperationLog log);
}