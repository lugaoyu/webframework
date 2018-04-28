package org.smart4j.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 接口代理类(CGLib动态代理)
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class CGLibProxy implements MethodInterceptor
{
    
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T)Enhancer.create(cls, this);
    }
    
    public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy proxy) throws Throwable
    {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    public void before(){
       System.out.println("调用目标方法增强前"); 
    }
    
    public void after(){
        System.out.println("调用目标方法增强后");
    }
    
}
