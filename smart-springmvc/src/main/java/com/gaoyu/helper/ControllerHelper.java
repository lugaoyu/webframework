package com.gaoyu.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gaoyu.annotation.RequestMapping;
import com.gaoyu.bean.Handler;
import com.gaoyu.bean.RequestBean;


/**HandlerMapping工具类
 * ClassName:ControllerHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月29日 上午9:32:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class ControllerHelper
{
    public static final Map<RequestBean, Handler> HANDLER_MAP = new HashMap<RequestBean, Handler>();
    
    static
    {
        Set<Class<?>> controllerClasses = ClassHelper.getControllerClass();
        if(controllerClasses != null && !controllerClasses.isEmpty())
        {
            for(Class<?> cls : controllerClasses)
            {
                Method[] methods = cls.getDeclaredMethods();
                if(methods != null && methods.length>0)
                {
                    for(Method method : methods)
                    {
                        if(method.isAnnotationPresent(RequestMapping.class))
                        {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            String urlValue = requestMapping.value();
                            String requestMethod = requestMapping.method();
                            RequestBean requestBean = new RequestBean(urlValue, requestMethod);
                            Handler handler = new Handler(cls, method);
                            HANDLER_MAP.put(requestBean, handler);
                        }
                    }
                }
            }
        }
    }
    
    public static Handler getHandler(RequestBean requestBean)
    {
        return HANDLER_MAP.get(requestBean);
    }
}
