/**
 * Project Name:smart-springmvc
 * File Name:CastUtils.java
 * Package Name:com.gaoyu.utils
 * Date:2018年3月27日上午10:56:14
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.utils;

/**数据类型转换工具类
 * ClassName:CastUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 上午10:56:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class CastUtils
{
    public static String castString(Object obj)
    {
        return castString(obj, "");
    }

    private static String castString(Object obj, String defaultValue)
    {
        String value = defaultValue;
        if(obj != null)
        {
            value = String.valueOf(obj);
        }
        return value;
    }
    
    public static int castInt(Object obj)
    {
        return castInt(obj, 0);
    }

    private static int castInt(Object obj, int defaultValue)
    {
        int value = defaultValue;
        if(obj != null)
        {
            String str = castString(obj);
            if(str != null)
            {
                try
                {
                    value = Integer.parseInt(str);
                }
                catch (NumberFormatException e)
                {
                    value = defaultValue;
                }
            }
        }
        return value;
    }
    
    public static long castLong(Object obj)
    {
         return castLong(obj,0l);
    }

    private static long castLong(Object obj, long defaultValue)
    {
        long value = defaultValue;
        if(obj != null)
        {
            String str = castString(obj);
            if(str != null)
            {
                try
                {
                    value = Long.parseLong(str);
                }
                catch (NumberFormatException e)
                {
                    value = defaultValue;
                }
            }
        }
        return value;
    }
    
    public static double castDouble(Object obj)
    {
        return castDouble(obj,0.0);
    }

    private static double castDouble(Object obj, double defaultValue)
    {
        Double value = defaultValue;
        if(obj != null)
        {
            String str = castString(obj);
            if(str != null)
            {
                try
                {
                    value = Double.parseDouble(str);
                }
                catch (NumberFormatException e)
                {
                    value = defaultValue;
                }
            }
        }
        return value;
    }
    
    public static boolean castBoolean(Object obj)
    {
        return obj == null ? null : Boolean.parseBoolean(obj.toString());
    }
}
