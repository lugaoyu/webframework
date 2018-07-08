package com.gaoyu.bootstrap;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CgLibProxy implements MethodInterceptor
{
        private Validate validate;
        
        public CgLibProxy(Validate validate)
        {
                this.validate = validate;
        }
        
        public <T> Object getInstance(Class<T> clazz)
        {
                return Enhancer.create(clazz, this);
        }
        
        public Object intercept(Object target, Method arg1, Object[] arg2,
                        MethodProxy proxy)
                throws Throwable
        {
                validate.validateParam();
                Object object = proxy.invokeSuper(target, arg2);
                validate.returnResult();
                return object;
        }
        
}
