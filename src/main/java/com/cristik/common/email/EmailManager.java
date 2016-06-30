package com.cristik.common.email;

/**
 * @Package: com.cristik.framework.email.EmailManager
 * @ClassName: EmailManager.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/6 14:07
 * @Version: v1.0
 */
public interface EmailManager {

    void placeOrder(Order order);

    void placeOrder();
}
