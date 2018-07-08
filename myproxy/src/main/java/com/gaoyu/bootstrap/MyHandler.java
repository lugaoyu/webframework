package com.gaoyu.bootstrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyHandler implements InvocationHandler
{
        private Object target;
        
        private Validate validate;
        
        public MyHandler(Object target, Validate validate)
        {
                this.target = target;
                this.validate = validate;
        }
        
        public Object getInstance()
        {
                return Proxy.newProxyInstance(target.getClass()
                                .getClassLoader(), target.getClass()
                                .getInterfaces(), this);
        }
        
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable
        {
                validate.validateParam();
                Object result = method.invoke(target, args);
                validate.returnResult();
                return result;
        }
}
