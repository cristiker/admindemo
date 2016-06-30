package com.cristik.common.shiro.realm;

import com.cristik.modules.test.entity.svo.Token;
import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.modules.test.service.ITokenService;
import com.cristik.modules.test.service.IUserLoginService;
import com.cristik.common.shiro.token.BearerHeaderToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhenghua on 2016/5/30.
 */
@Component
public class TokenRealm extends AuthorizingRealm {

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private IUserLoginService userLoginService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof BearerHeaderToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String tokenStr = (String)token.getPrincipal();
        Token tokenObj  = tokenService.getToken(tokenStr);
        if(tokenObj==null){
            throw new IncorrectCredentialsException();
        }else{
            if(tokenObj.getExpTime().after(new Date())){
                UserLogin userLogin = userLoginService.findByUserId(tokenObj.getUserId());
                return new SimpleAuthenticationInfo(
                        userLogin.getLoginName(), //用户名
                        userLogin.getPassword(), //密码
                        getName()//realm name
                );
            }else{
                //凭证已过期
                throw new ExpiredCredentialsException();
            }
        }
    }
}
