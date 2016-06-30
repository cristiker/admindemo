package com.cristik.redis;

import com.cristik.modules.test.entity.svo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Package: com.cristik.redis.RedisTest
 * @ClassName: RedisTest.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/8 13:47
 * @Version: v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class RedisTest {
    @Autowired
    RedisTemplate<String,String> template;

    @Resource(name="redisTemplate")
    private ListOperations<String,String> listOp;

    @Resource(name="redisTemplate")
    private ValueOperations<String,String> valueOp;

    @Test
    public void testKeys(){
        Set<String> keys = template.keys("11");
        System.out.println(keys);
    }

    @Test
    public void testConnection(){
        RedisConnection connection = template.getConnectionFactory().getConnection();
        System.out.println(connection);
    }

    @Test
    public void testListOp(){
        listOp.leftPush("login:last_login_times","10000");
        listOp.leftPush("login:last_login_times","10001");
        listOp.leftPush("login:last_login_times","10002");
        listOp.leftPush("login:last_login_times","10003");
        listOp.rightPush("login:last_login_times","10004");
        Object obj = listOp.rightPop("login:last_login_times");
        Object obj2 = listOp.rightPop("login:last_login_times");
        System.out.println(obj);
    }

    @Test
    public void testValueOp(){
        User user = new User();
        RedisSerializer valueSerializer = template.getValueSerializer();
        valueSerializer.serialize(user);
        valueOp.set("tom",valueSerializer.serialize(user).toString());
        String key = valueOp.get("tom");
        System.out.println(key);
    }

}
