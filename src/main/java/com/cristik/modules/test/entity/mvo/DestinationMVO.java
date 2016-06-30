package com.cristik.modules.test.entity.mvo;

import com.cristik.modules.test.entity.svo.Destination;

/**
 * Created by zhenghua on 2016/5/13.
 */
public class DestinationMVO extends Destination {

    private String country;

    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
