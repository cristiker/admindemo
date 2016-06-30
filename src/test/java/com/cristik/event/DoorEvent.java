package com.cristik.event;

import java.util.EventObject;

/**
 * @Package: com.cristik.event.DoorEvent
 * @ClassName: DoorEvent.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/13 12:59
 * @Version: v1.0
 */
public class DoorEvent extends EventObject {

    private String doorState = "";//表示门的状态，有“开”和“关”两种

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source ,String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }
}
