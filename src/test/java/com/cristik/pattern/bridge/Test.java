package com.cristik.pattern.bridge;

import com.cristik.pattern.bridge.abstra.AbstractRoad;
import com.cristik.pattern.bridge.abstra.People;

/**
 * @Package: com.cristik.pattern.bridge.Test
 * @ClassName: Test.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 15:12
 * @Version: v1.0
 */
public class Test {
    public static void main(String[] args) {
        AbstractRoad speedWay = new SpeedWay();
        speedWay.aCar = new Bus();
        speedWay.run();

        AbstractRoad street = new Street();
        street.aCar = new Bus();
        street.run();

        People man = new Man();
        man.road=speedWay;
        man.run();
    }
}
