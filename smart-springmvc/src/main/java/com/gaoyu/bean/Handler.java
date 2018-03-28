package com.gaoyu.bean;

import java.lang.reflect.Method;


/**封装Handler的实体
 * ClassName:Handler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2018年3月28日 上午09:41:14 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see      
 */
public class Handler
{
    private Class<?> controllerClass;
    private Method actionMethod;
    
    public Handler(Class<?> controllerClass, Method actionMethod)
    {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }
    
    public Class<?> getControllerClass()
    {
        return controllerClass;
    }
    public void setControllerClass(Class<?> controllerClass)
    {
        this.controllerClass = controllerClass;
    }
    public Method getActionMethod()
    {
        return actionMethod;
    }
    public void setActionMethod(Method actionMethod)
    {
        this.actionMethod = actionMethod;
    }
}
