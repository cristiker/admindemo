package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String destinationName;
    @Column
    private Integer countryId;
    @Column
    private Integer stateId;
    @Column
    private Integer status;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Destination(Integer id, String destinationName, Integer countryId, Integer stateId, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.destinationName = destinationName;
        this.countryId = countryId;
        this.stateId = stateId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Destination() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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