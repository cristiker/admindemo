package com.cristik.pattern.bridge;

import com.cristik.pattern.bridge.abstra.AbstractCar;

/**
 * @Package: com.cristik.pattern.bridge.Bus
 * @ClassName: Bus.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 15:10
 * @Version: v1.0
 */
public class Bus extends AbstractCar {

    @Override
    public void run() {
        super.run();
        System.out.print("公交车");
    }
}
