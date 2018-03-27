/**
 * Project Name:smart-springmvc
 * File Name:PropertiesUtils.java
 * Package Name:com.gaoyu.utils
 * Date:2018年3月27日 下午16:15:14
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.helper;

import java.util.HashSet;
import java.util.Set;

import com.gaoyu.annotation.Controller;
import com.gaoyu.annotation.Repository;
import com.gaoyu.annotation.Service;
import com.gaoyu.utils.ClassUtils;


/**类工具类
 * ClassName:ClassHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午16:15:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class ClassHelper
{
    private static final Set<Class<?>> CLASS_SET;
    static
    {
        CLASS_SET = ClassUtils.getClassSet("com.gao.yu");
    }
    
    public static Set<Class<?>> getClassSet()
    {
        return CLASS_SET;
    }
    
    public static Set<Class<?>> getControllerClass()
    {
        Set<Class<?>> controllerClasses = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET)
        {
            if(cls.getAnnotation(Controller.class) != null)
            {
                controllerClasses.add(cls);
            }
        }
        return controllerClasses;
    }
    
    public static Set<Class<?>> getServiceClass()
    {
        Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET)
        {
            if(cls.getAnnotation(Service.class) != null)
            {
               serviceClasses.add(cls); 
            }
        }
        return serviceClasses;
    }
    
    public static Set<Class<?>> getRepositoryClass()
    {
        Set<Class<?>> repositoryClasses = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET)
        {
            if(cls.getAnnotation(Repository.class) != null)
            {
                repositoryClasses.add(cls);
            }
        }
        return repositoryClasses;
    }
}
