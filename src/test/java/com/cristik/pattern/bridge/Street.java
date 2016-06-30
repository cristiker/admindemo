package com.cristik.pattern.bridge;

import com.cristik.pattern.bridge.abstra.AbstractRoad;

/**
 * @Package: com.cristik.pattern.bridge.Street
 * @ClassName: Street.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 14:53
 * @Version: v1.0
 */
public class Street extends AbstractRoad {

    @Override
    public void run() {
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
