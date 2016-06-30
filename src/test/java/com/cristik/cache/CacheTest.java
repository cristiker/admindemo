package com.cristik.cache;

import org.junit.Test;
import com.cristik.modules.test.service.impl.DictionarysServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by zhenghua on 2016/3/31.
 */
public class CacheTest {

    @Test
    public void testCache(){
        ApplicationContext context = new GenericXmlApplicationContext("spring-context.xml");
        DictionarysServiceImpl service =  context.getBean("dictionarysService", DictionarysServiceImpl.class);
        service.loadCaches();

        /*HelloService helloService =  context.getBean("helloService", HelloService.class);
        //First method execution using key="Josh", not cached
        System.out.println("message: " + helloService.getMessage("Josh","20"));
        //Second method execution using key="Josh", still not cached
        System.out.println("message: " + helloService.getMessage("Josh","30"));
        //First method execution using key="Joshua", not cached
        System.out.println("message: " + helloService.getMessage("Joshua","40"));
        //Second method execution using key="Joshua", cached
        System.out.println("message: " + helloService.getMessage("Joshua","50"));
        System.out.println("Done.");*/
    }
}
