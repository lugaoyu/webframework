package com.gaoyu.bootstrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class MyHandler implements InvocationHandler
{
    private Object target;
    public MyHandler(Object target)
    {
        this.target = target;
    }
    
    public Object getInstance()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.err.println("执行开始时间: "+ new Date());
        Object result = method.invoke(target, args);
        System.err.println("执行结束时间: "+ new Date());
        return result;
    }
}
