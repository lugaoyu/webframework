package org.smart4j.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 接口代理类(jdk动态代理)
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class DynamicProxy implements InvocationHandler
{
    private Object target;
    
    public DynamicProxy(Object target){
        this.target = target;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
    
    private void before(){
        System.out.println("调用目标方法增强前");
    }
    
    private void after(){
        System.out.println("调用目标方法增强后");
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    
}
