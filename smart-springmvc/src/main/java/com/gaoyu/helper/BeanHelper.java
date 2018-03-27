package com.gaoyu.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gaoyu.utils.ReflectionUtils;


/**类工具类
 * ClassName:BeanHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午19:40:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class BeanHelper
{
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
    static
    {
        Set<Class<?>> classSet = ClassHelper.getClassSet();
        if(classSet != null && classSet.size() >0)
        {
            for(Class<?> cls : classSet)
            {
                BEAN_MAP.put(cls, ReflectionUtils.getInstance(cls));
            }
        }
    }
    
    public static Map<Class<?>, Object> getBeanMap()
    {
        return BEAN_MAP;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls)
    {
        if(!BEAN_MAP.containsKey(cls))
        {
            throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
}
