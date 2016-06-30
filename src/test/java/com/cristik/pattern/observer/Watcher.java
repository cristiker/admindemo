package com.cristik.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Package: com.cristik.pattern.observer.Watcher
 * @ClassName: Watcher.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:50
 * @Version: v1.0
 */
public class Watcher implements Observer {
    private String name = "watcher";

    public Watcher(String name) {
        this.name += name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("this is "+ name +" I got the meessage: "+arg);
    }
}
