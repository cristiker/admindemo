package com.cristik.thread.test;

/**
 * @Package: com.cristik.thread.test.ConnectionManager
 * @ClassName: ConnectionManager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/12 10:17
 * @Version: v1.0
 */
public class ConnectionManager {

    private static ThreadLocal<Integer> idsHolder = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            Integer id = (int)Math.random();
            return id;
        }
    };

    public static Integer getId(String name) {
        System.out.println("getConnection(" + name + ")");
        return idsHolder.get();
    }

    public static void setId(Integer id) {
        idsHolder.set(id);
    }

}
