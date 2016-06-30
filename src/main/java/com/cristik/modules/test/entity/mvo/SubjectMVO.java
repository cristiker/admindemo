package com.cristik.modules.test.entity.mvo;

import com.cristik.modules.test.entity.svo.Subject;

/**
 * Created by zhenghua on 2016/5/30.
 */
public class SubjectMVO extends Subject{

    //主题相关景点数
    private Integer sightCount;

    public SubjectMVO() {
    }

    public Integer getSightCount() {
        return sightCount;
    }

    public void setSightCount(Integer sightCount) {
        this.sightCount = sightCount;
    }

    @Override
    public String toString() {
        return "SubjectMVO{" +
                "sightCount=" + sightCount +
                '}';
    }
}
