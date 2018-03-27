/**
 * Project Name:smart-springmvc
 * File Name:CastUtils.java
 * Package Name:com.gaoyu.utils
 * Date:2018年3月27日 下午14:03:14
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**类加载工具类
 * ClassName:ClassUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午14:03:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class ClassUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtils.class);
    
    public static ClassLoader getClassLoader()
    {
        return Thread.currentThread().getContextClassLoader();
    }
    
    public static Class<?> loadClass(String className,boolean isInitialized)
    {
        Class<?> cls = null;
        try
        {
            cls = Class.forName(className, isInitialized, getClassLoader());
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.error("class not found",e);
            throw new RuntimeException(e);
        }
        return cls;
    }
    
    public static Set<Class<?>> getClassSet(String packageName)
    {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try
        {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while (urls.hasMoreElements())
            {
                URL url = urls.nextElement();
                if(url != null)
                {
                    String protocol = url.getProtocol();
                    if(protocol.equals("file"))
                    {
                        String packagePath = url.getPath().replaceAll("20%", "");
                        //包路径//遍历包路径下所有class文件
                        addClass(classSet,packageName,packagePath);
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return classSet;
    }

    /**
     * 
     * @param classSet
     * @param packageName com.gao.yu
     * @param packagePath /../../../gao/yu
     */
    private static void addClass(Set<Class<?>> classSet, String packageName, String packagePath)
    {
        File[] files = new File(packagePath).listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                return (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class")));
            }
        });
        
       for(File file : files)
       {
           String fileName = file.getName();
           if(file.isFile())
           {
               String className = fileName.substring(0, fileName.lastIndexOf("."));
               className = packageName + "." + className;
               doAddClass(classSet,className);
           }
           else 
           {
               String subPackagePath = fileName;
               subPackagePath = packagePath + "/" + subPackagePath;
               packageName = packageName + "." + subPackagePath;
               addClass(classSet, packageName, packagePath);
           }
           
       }
    }

    private static void doAddClass(Set<Class<?>> classSet, String className)
    {
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }

}
