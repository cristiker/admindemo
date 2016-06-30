package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="header")
public class Header {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String headImg;
    @Column
    private String title;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Header(Integer id, String headImg, String title, Date createTime, Date updateTime) {
        this.id = id;
        this.headImg = headImg;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Header() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Header{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", headImg='" + headImg + '\'' +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}