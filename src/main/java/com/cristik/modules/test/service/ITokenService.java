package com.cristik.modules.test.service;


import com.cristik.modules.test.entity.svo.Token;

/**
 * Created by zhenghua on 2016/5/26.
 */

public interface ITokenService {

    boolean insert(Token token);

    boolean deleteToken(Token token);

    Token getToken(String token);


}
