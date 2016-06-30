package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="sight")
public class Sight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String sightName;
    @Column
    private Integer destinationId;
    @Column
    private String address;
    @Column
    private String sightImg;
    @Column
    private Integer type;
    @Column
    private Integer guideId;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
    @Column
    private String summary;

    public Sight(Integer id, String sightName, Integer destinationId, String address, String sightImg, Integer type, Integer guideId, Integer status, Date createTime, Date updateTime, String summary) {
        this.id = id;
        this.sightName = sightName;
        this.destinationId = destinationId;
        this.address = address;
        this.sightImg = sightImg;
        this.type = type;
        this.guideId = guideId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.summary = summary;
    }

    public Sight() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSightImg() {
        return sightImg;
    }

    public void setSightImg(String sightImg) {
        this.sightImg = sightImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", sightName='" + sightName + '\'' +
                ", destinationId=" + destinationId +
                ", sightImg='" + sightImg + '\'' +
                ", type=" + type +
                ", guideId=" + guideId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", summary='" + summary + '\'' +
                '}';
    }
}