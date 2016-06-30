package com.cristik.common.shiro.realm;

import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.modules.test.service.IUserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserLoginService userLoginService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userLoginService.findRoles(username));
        authorizationInfo.setStringPermissions(userLoginService.findPermissions(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        UserLogin userLogin = userLoginService.findByUsername(username);

        if(userLogin == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(userLogin.getStatus()==2) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userLogin.getLoginName(), //用户名
                userLogin.getPassword(), //密码
                ByteSource.Util.bytes(userLogin.getSalt()),//salt=username+salt
                getName()//realm name
        );
        return authenticationInfo;
    }

}
