package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String picName;
    @Column
    private String picLocation;
    @Column
    private String url;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Image(Integer id, String picName, String picLocation, String url, Date createTime, Date updateTime) {
        this.id = id;
        this.picName = picName;
        this.picLocation = picLocation;
        this.url = url;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Image() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicLocation() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation = picLocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "Image{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", picName='" + picName + '\'' +
                ", picLocation='" + picLocation + '\'' +
                ", url='" + url + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}