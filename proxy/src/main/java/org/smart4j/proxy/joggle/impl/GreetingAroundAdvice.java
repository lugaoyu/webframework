package org.smart4j.proxy.joggle.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * AOP环绕增强
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class GreetingAroundAdvice implements MethodInterceptor
{
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }
    
    public void before(){
        System.out.println("Before");
    }
    
    public void after(){
        System.out.println("After");
    }
}
