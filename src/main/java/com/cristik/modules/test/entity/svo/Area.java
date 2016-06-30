package com.cristik.modules.test.entity.svo;

import javax.persistence.*;

@Table(name="area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String areaName;
    @Column
    private String enName;
    @Column
    private String showImg;
    @Column
    private String areaImgs;
    @Column
    private Integer parentId;
    @Column
    private Integer type;

    public Area() {
    }

    public Area(String areaImgs, String areaName, String enName, Integer parentId, String showImg, Integer type) {
        this.areaImgs = areaImgs;
        this.areaName = areaName;
        this.enName = enName;
        this.parentId = parentId;
        this.showImg = showImg;
        this.type = type;
    }

    public String getAreaImgs() {
        return areaImgs;
    }

    public void setAreaImgs(String areaImgs) {
        this.areaImgs = areaImgs;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaImgs='" + areaImgs + '\'' +
                ", id=" + id +
                ", areaName='" + areaName + '\'' +
                ", enName='" + enName + '\'' +
                ", showImg='" + showImg + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                '}';
    }
}