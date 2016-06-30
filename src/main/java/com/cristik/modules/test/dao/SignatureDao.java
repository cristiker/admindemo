package com.cristik.modules.test.dao;

import com.cristik.modules.test.entity.test.Signature;
import tk.mybatis.mapper.common.Mapper;

public interface SignatureDao extends Mapper<Signature> {

    int insertSignature(Signature signature);
}