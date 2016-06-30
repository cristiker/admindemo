package com.cristik.pattern.bridge;

import com.cristik.pattern.bridge.abstra.People;

/**
 * @Package: com.cristik.pattern.bridge.Woman
 * @ClassName: Woman.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/14 15:21
 * @Version: v1.0
 */
public class Woman extends People {

    @Override
    public void run() {
        super.run();
        System.out.print("男人开着");
        road.run();
    }
}
