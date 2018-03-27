package com.gaoyu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**反射工具类
 * ClassName:ReflectionUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午14:03:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class ReflectionUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtils.class);
    
    public static Object getInstance(Class<?> cls)
    {
        Object instance;
        try
        {
            instance = cls.newInstance();
        }
        catch (Exception e)
        {
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }
    
    public static void setField(Object obj, Field field, Object value)
    {
        try
        {
            field.setAccessible(true);
            field.set(obj, value);
        }
        catch (IllegalArgumentException | IllegalAccessException e)
        {
            LOGGER.error("set field failure");
            throw new RuntimeException(e);
        }
    }
    
    public static Object invokeMethod(Object obj, Method method, Object ...params)
    {
        Object result;
        try
        {
            method.setAccessible(true);
            result = method.invoke(obj, params);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            LOGGER.error("invoke method failure");
            throw new RuntimeException(e);
        }
        return result;
    }
}
