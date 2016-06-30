package com.cristik.pattern.observer;

/**
 * @Package: com.cristik.pattern.observer.Manager
 * @ClassName: Manager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:52
 * @Version: v1.0
 */
public class Manager {

    public static void main(String[] args) {
        Subject subject = new Subject();
        for(int i=0;i<10;i++){
            Watcher watcher = new Watcher(new Integer(i).toString());
            subject.addObserver(watcher);
        }
        subject.updateMessage("tell me why");
    }

}
