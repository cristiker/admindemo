package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="user_login")
public class UserLogin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String loginName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Column
    private String salt;
    @Column
    private Integer type;
    @Column
    private Integer status;//1正常2禁用
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public UserLogin(Integer id, String loginName, String email, String phone, String password, String salt, Integer type, Integer status, Date createTime, Date updateTime, String flag) {
        this.id = id;
        this.loginName = loginName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.type = type;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserLogin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "UserLogin{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", loginName='" + loginName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", updateTime=" + updateTime +
                '}';
    }
}