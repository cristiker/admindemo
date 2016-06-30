package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.SignatureDao;
import com.cristik.modules.test.entity.test.Signature;
import com.cristik.modules.test.service.ISignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/3/30.
 */
@Service
public class SignatureServiceImpl implements ISignatureService{
    @Autowired
    SignatureDao signatureDao;

    public int insertSignature(Signature signature){
        int id = signatureDao.insert(signature);
        //int id2 = signatureMapper.insert(signature);
        /*signatureMapper.insertSignature()*/
        return id;
    }
}
