package com.cristik.shiro;

import junit.framework.Assert;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by zhenghua on 2016/3/14.
 */
public class ShiroTest {
    protected static Logger logger = Logger.getLogger(ShiroTest.class);

    /**
     * 测试shiro用户登录验证
     */
    @Test
    public void testShiroLogin(){
        //加载shiro.ini配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            logger.error("登录失败");
            e.printStackTrace();
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testCustomRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            logger.info("登录失败");
            e.printStackTrace();
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testMultiCustomRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            logger.info("登录失败");
            e.printStackTrace();
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testJDBCRealm(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/goself");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setAuthenticationQuery("SELECT PASSWORD FORM USER_LOGIN WHERE LOGIN_NAME = ?");
        jdbcRealm.setUserRolesQuery("SELECT ID FROM ROLES WHERE ID =(SELECT ROLE_ID FROM USER_ROLES WHERE LOGIN_ID = (SELECT ID FROM USER_LOGIN WHERE LOGIN_NAME = ?))");
        jdbcRealm.setPermissionsQuery("SELECT NAME FROM permission WHERE id in (SELECT permissionId FROM permission_role WHERE (SELECT id FROM role WHERE NAME = ?))");


    }

}
