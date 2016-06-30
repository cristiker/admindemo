package com.cristik.modules.test.entity.test;

import javax.persistence.*;
import java.util.Date;

@Table(name="operation_log")
public class OperationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String userid;
    @Column
    private Date createdate;
    @Column
    private String content;
    @Column
    private String operation;

    public OperationLog(Integer id, String userid, Date createdate, String content, String operation) {
        this.id = id;
        this.userid = userid;
        this.createdate = createdate;
        this.content = content;
        this.operation = operation;
    }

    public OperationLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", createdate=" + createdate +
                ", content='" + content + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    @Table(name="permission")
    public static class Permission {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        @Column
        private String permission;
        @Column
        private String description;
        @Column
        private Integer status;//1未启用2已启用
        @Column
        private Date createTime;
        @Column
        private Date updateTime;

        public Permission(Integer id, String permission, String description, Integer status, Date createTime, Date updateTime) {
            this.id = id;
            this.permission = permission;
            this.description = description;
            this.status = status;
            this.createTime = createTime;
            this.updateTime = updateTime;
        }

        public Permission() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPermission() {
            return permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
    }

    @Table(name="role")
    public static class Role {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        @Column
        private String roleCode;
        @Column
        private String description;
        @Column
        private Integer status;//1:未启用 2:已启用
        @Column
        private Date createTime;
        @Column
        private Date updateTime;

        public Role(Integer id, String roleCode, String description, Integer status, Date createTime, Date updateTime) {
            this.id = id;
            this.roleCode = roleCode;
            this.description = description;
            this.status = status;
            this.createTime = createTime;
            this.updateTime = updateTime;
        }

        public Role() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getRoleCode() {
            return roleCode;
        }

        public void setRoleCode(String roleCode) {
            this.roleCode = roleCode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
    }
}