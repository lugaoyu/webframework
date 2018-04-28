package org.smart4j.proxy.joggle.impl;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置增强
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class GreetingAfterAdvice implements AfterReturningAdvice
{
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable
    {
        System.out.println("After");
    }
    
}
