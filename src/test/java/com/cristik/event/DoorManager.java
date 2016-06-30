package com.cristik.event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Package: com.cristik.event.DoorManager
 * @ClassName: DoorManager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:03
 * @Version: v1.0
 */
public class DoorManager {

    private Collection listeners;

    /**
     * 添加事件
     * @param listener DoorListener
     */
    public void addDoorListener(DoorListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     * @param listener DoorListener
     */
    public void removeDoorListener(DoorListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        Iterator iter = listeners.iterator();
        while (iter.hasNext()) {
            DoorListener listener = (DoorListener) iter.next();
            listener.doorEvent(event);
        }
    }

    public static void main(String []args)
    {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());//给门1增加监听器
        manager.addDoorListener(new DoorListener2());//给门2增加监听器
        //开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");
        //关门
        manager.fireWorkspaceClosed();
    }
}
