package com.cristik.common.utils;

import com.cristik.modules.test.entity.svo.UserLogin;
import com.cristik.common.exception.BusinessException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by zhenghua on 2016/4/26.
 */
public class PasswordUtil {

    public static void encryptPassword(UserLogin userLogin) throws BusinessException {
        RandomNumberGenerator randomNumberGenerator  = new SecureRandomNumberGenerator();
        String  password = userLogin.getPassword();
        if(StringUtils.isNotBlank(password)){
            userLogin.setSalt(randomNumberGenerator.nextBytes().toHex());
            password = password + userLogin.getSalt();
            String pwd =  DigestUtils.md5Hex(password.toLowerCase().getBytes());
            userLogin.setPassword(pwd);
        }else{
            throw new BusinessException("密码为空");
        }
    }

    public static void encryptPasswordBySimpleHash(UserLogin userLogin) throws BusinessException {
        RandomNumberGenerator randomNumberGenerator  = new SecureRandomNumberGenerator();
        String algorithmName = "md5";
        int hashIterations = 2;
        userLogin.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName,userLogin.getPassword(),
                ByteSource.Util.bytes(userLogin.getSalt()),hashIterations).toHex();
        userLogin.setPassword(newPassword);
    }

}
