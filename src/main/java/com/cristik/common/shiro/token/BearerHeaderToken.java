package com.cristik.common.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by zhenghua on 2016/5/30.
 */
public class BearerHeaderToken implements AuthenticationToken {

    private String token;

    public BearerHeaderToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
