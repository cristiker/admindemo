package com.cristik.pattern.observer;

import java.util.Observable;

/**
 * @Package: com.cristik.pattern.observer.Subject
 * @ClassName: Subject.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:49
 * @Version: v1.0
 */
public class Subject extends Observable {

    private String message = "";

    public void updateMessage(String message){
        this.message=message;
        setChanged();
        notifyObservers(message);
    }

}
