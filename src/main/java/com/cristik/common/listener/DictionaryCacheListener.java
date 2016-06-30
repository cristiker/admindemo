package com.cristik.common.listener;

import com.cristik.modules.test.service.impl.DictionarysServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by zhenghua on 2016/4/1.
 */
public class DictionaryCacheListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        DictionarysServiceImpl service = (DictionarysServiceImpl) webApplicationContext.getBean("dictionarysService");
        service.loadCaches();
    }
}
