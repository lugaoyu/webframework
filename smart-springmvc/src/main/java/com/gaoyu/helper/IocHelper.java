package com.gaoyu.helper;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import com.gaoyu.annotation.Autowired;
import com.gaoyu.utils.ReflectionUtils;


/**IOC工具类
 * ClassName:IocHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月27日 下午19:46:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class IocHelper
{
    static
    {
        Map<Class<?>, Object> BEAN_MAP = BeanHelper.getBeanMap();
        if(!BEAN_MAP.isEmpty())
        {
            for(Entry<Class<?>, Object> entry : BEAN_MAP.entrySet())
            {
                Class<?> key = entry.getKey();
                Object value = entry.getValue();
                Field[] fields = key.getDeclaredFields();
                for(Field field : fields)
                {
                    if(field.isAnnotationPresent(Autowired.class))
                    {
                        Class<?> cls = field.getType();
                        Object obj = BEAN_MAP.get(cls);
                        ReflectionUtils.setField(value, field, obj);
                    }
                }
            }
        }
    }
}
