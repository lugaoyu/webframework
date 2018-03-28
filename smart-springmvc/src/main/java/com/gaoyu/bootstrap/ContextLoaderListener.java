package com.gaoyu.bootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoyu.helper.BeanHelper;
import com.gaoyu.helper.ClassHelper;
import com.gaoyu.helper.ControllerHelper;
import com.gaoyu.helper.IocHelper;
import com.gaoyu.utils.ClassUtils;


public class ContextLoaderListener implements ServletContextListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextLoaderListener.class);
    
    public void contextInitialized(ServletContextEvent arg0)
    {
        LOGGER.info("容器初始化开始");
        init();
        LOGGER.info("容器初始化结束");
    }
    
    public void init()
    {
        Class<?>[] classList =
        {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class };
        for(Class<?> cls : classList){
            ClassUtils.loadClass(cls.getName(),true);
        }
    }
    
    public void contextDestroyed(ServletContextEvent arg0)
    {
        System.out.println("容器關閉時,該再此方法裏關閉資源");
    }
}
