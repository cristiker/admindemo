package com.cristik.modules.test.entity.test;

import javax.persistence.*;
import java.util.Date;

@Table(name="signature")
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer secretId;
    @Column
    private String secretKey;
    @Column
    private String userId;

    public Signature(Integer secretId, String secretKey, String userId) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        this.userId = userId;
    }

    public Signature() {
        super();
    }

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Table(name="user")
    public static class User {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        @Column
        private String name;
        @Column
        private String userName;
        @Column
        private String email;
        @Column
        private String phone;
        @Column
        private String sex;
        @Column
        private Integer age;
        @Column
        private Integer status;//1正常2禁用
        @Column
        private Date createTime;
        @Column
        private Date updateTime;
        @Column
        private String flag="A";//A正常 P删除

        public User(Integer id, String name, String userName, String email, String phone, String sex, Integer age, Integer status, Date createTime, Date updateTime, String flag) {
            this.id = id;
            this.name = name;
            this.userName = userName;
            this.email = email;
            this.phone = phone;
            this.sex = sex;
            this.age = age;
            this.status = status;
            this.createTime = createTime;
            this.updateTime = updateTime;
            this.flag = flag;
        }

        public User() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}