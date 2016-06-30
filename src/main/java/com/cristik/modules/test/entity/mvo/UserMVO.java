package com.cristik.modules.test.entity.mvo;

import com.cristik.modules.test.entity.svo.User;

import java.util.Date;

/**
 * Created by zhenghua on 2016/3/18.
 */
public class UserMVO extends User {

    String password ;

    public UserMVO() {
    }

    public UserMVO(Integer id, String name, String userName,String userImage, String email, String phone, String sex, Integer age, Integer status, Date createTime, Date updateTime, String flag, String password) {
        super(id, name, userName,userImage, email, phone, sex, age, status, createTime, updateTime);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserMVO{" +
                "password='" + password + '\'' +
                '}';
    }
}
