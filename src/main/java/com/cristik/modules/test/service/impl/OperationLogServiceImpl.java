package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.OperationLogDao;
import com.cristik.modules.test.entity.test.OperationLog;
import com.cristik.modules.test.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/3/29.
 */
@Service
public class OperationLogServiceImpl implements IOperationLogService{

    @Autowired
    OperationLogDao operationLogMapper;

    public void log(OperationLog log){
        operationLogMapper.insert(log);
    }
}
