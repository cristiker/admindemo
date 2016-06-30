package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.TokenDao;
import com.cristik.modules.test.entity.svo.Token;
import com.cristik.modules.test.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhenghua on 2016/5/26.
 */
@Service
@Transactional
public class TokenServiceImpl implements ITokenService {

    @Autowired
    TokenDao tokenDao;

    @Override
    public boolean insert(Token token) {
        int num = tokenDao.insert(token);
        if(num==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteToken(Token token) {
        int num = tokenDao.delete(token);
        return num==1;
    }

    @Override
    public Token getToken(String str) {
        Token token = new Token();
        token.setToken(str);
        List<Token> list = tokenDao.select(token);
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }


}
