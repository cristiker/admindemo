package com.cristik.modules.test.entity.mvo;

import com.cristik.modules.test.entity.svo.Sight;

import java.util.Date;

/**
 * Created by zhenghua on 2016/5/17.
 */
public class SightMVO extends Sight {

    private String destinationName;

    public SightMVO() {
    }

    public SightMVO(String destinationName) {
        this.destinationName = destinationName;
    }

    public SightMVO(Integer id, String sightName, Integer destinationId, String address, String sightImg, Integer type, Integer guideId, Integer status, Date createTime, Date updateTime, String summary, String destinationName) {
        super(id, sightName, destinationId, address, sightImg, type, guideId, status, createTime, updateTime, summary);
        this.destinationName = destinationName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Override
    public String toString() {
        return "SightMVO{" +
                "destinationName='" + destinationName + '\'' +
                '}';
    }
}
