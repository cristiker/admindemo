package com.cristik.event;

/**
 * @Package: com.cristik.event.DoorListener1
 * @ClassName: DoorListener1.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 13:02
 * @Version: v1.0
 */
public class DoorListener1 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        if(event.getDoorState()!=null&&event.getDoorState().equals("open"))
        {
            System.out.println("门1打开");
        }
        else
        {
            System.out.println("门1关闭");
        }
    }
}
