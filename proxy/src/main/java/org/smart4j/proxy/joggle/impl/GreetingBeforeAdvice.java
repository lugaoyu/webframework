package org.smart4j.proxy.joggle.impl;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置增强
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice
{
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable
    {
        System.out.println("Before");
    }
    
}
