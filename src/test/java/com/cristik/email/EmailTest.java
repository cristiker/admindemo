package com.cristik.email;

import com.cristik.common.email.EmailManager;
import com.cristik.common.email.Order;
import com.cristik.common.email.OrderManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Package: com.cristik.email.EmailTest
 * @ClassName: EmailTest.java
 * @Description: 测试邮箱发送
 * @Author: zhenghua
 * @CreateDate: 2016/6/6 11:18
 * @Version: v1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class EmailTest {
    @Autowired
    OrderManager orderManager;

    @Autowired
    EmailManager emailManager;


    @Test
    public void testEmail(){
        orderManager.placeOrder(new Order());
    }

    @Test
    public void testEmail2(){
        emailManager.placeOrder(new Order());
    }

    @Test
    public void testEmail3(){
        long beginTime = System.currentTimeMillis();
        for(int i=0;i<3;i++){
            emailManager.placeOrder(new Order());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("test-time:"+(endTime-beginTime));
    }


}
