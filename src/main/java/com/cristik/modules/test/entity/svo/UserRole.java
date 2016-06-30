package com.cristik.modules.test.entity.svo;

import javax.persistence.*;

@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer loginId;
    @Column
    private Integer roleId;

    public UserRole(Integer id, Integer loginId, Integer roleId) {
        this.id = id;
        this.loginId = loginId;
        this.roleId = roleId;
    }

    public UserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}