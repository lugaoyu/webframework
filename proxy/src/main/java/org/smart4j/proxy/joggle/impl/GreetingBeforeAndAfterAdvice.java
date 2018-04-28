package org.smart4j.proxy.joggle.impl;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice
{
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable
    {
        System.out.println("After");
    }
    
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable
    {
        System.out.println("Before");
    }
    
}
