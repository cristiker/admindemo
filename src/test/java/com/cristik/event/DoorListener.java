package com.cristik.event;

import java.util.EventListener;

/**
 * @Package: com.cristik.event.DoorListener
 * @ClassName: DoorListener.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:00
 * @Version: v1.0
 */
public interface DoorListener extends EventListener {

    public void doorEvent(DoorEvent event);

}
