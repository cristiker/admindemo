package com.cristik.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by zhenghua on 2016/3/15.
 */
public class MyRealm2 implements Realm{

    @Override
    public String getName() {
        return "myrealm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if(!"zhang".equalsIgnoreCase(userName)){
            throw new IncorrectCredentialsException();
        }
        if("1234".equals(password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
