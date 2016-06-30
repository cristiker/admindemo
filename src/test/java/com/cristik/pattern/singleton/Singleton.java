package com.cristik.pattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Package: com.cristik.pattern.singleton.Singleton
 * @ClassName: Singleton.java
 * @Description: 懒汉式未考虑线程安全
 * @Author:
 * @CreateDate: 2016/6/13 15:30
 * @Version: v1.0
 */
public class Singleton {
    private Singleton() {}
    private static Singleton single= null;
    public static synchronized Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance2() {
        return LazyHolder.INSTANCE;
    }




    public static void main(String[] args) {
        final Set<Singleton> count = Collections.synchronizedSet(new HashSet<Singleton>());
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Singleton t = getInstance();
                count.add(t);
                System.out.println("be adding");
            }
        };
        Thread t = new Thread(task);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t.start();
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(Singleton e:count){
            System.out.println(e);
        }
        System.out.println(count.size());
        count.size();
    }

}
