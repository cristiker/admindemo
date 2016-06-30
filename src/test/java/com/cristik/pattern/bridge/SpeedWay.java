package com.cristik.pattern.bridge;

import com.cristik.pattern.bridge.abstra.AbstractRoad;

/**
 * @Package: com.cristik.pattern.bridge.SpeedWay
 * @ClassName: SpeedWay.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 14:58
 * @Version: v1.0
 */
public class SpeedWay extends AbstractRoad {

    @Override
    public void run() {
        super.run();
        aCar.run();
        System.out.println("在高速公路行驶");
    }
}
