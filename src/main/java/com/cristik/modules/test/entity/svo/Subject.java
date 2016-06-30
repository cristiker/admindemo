package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String subjectName;
    @Column
    private String subjectContent;
    @Column
    private String subjectImg;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Subject(Integer id, String subjectName, String subjectImg, Integer status, Date createTime, Date updateTime, String subjectContent) {
        this.id = id;
        this.subjectName = subjectName;
        this.subjectImg = subjectImg;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.subjectContent = subjectContent;
    }

    public Subject() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectImg() {
        return subjectImg;
    }

    public void setSubjectImg(String subjectImg) {
        this.subjectImg = subjectImg;
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

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
    }
}