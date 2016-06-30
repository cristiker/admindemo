package com.cristik.common.utils;

import java.util.UUID;

/**
 * Created by zhenghua on 2016/3/21.
 */
public class IdUtil {
    public static String getId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
