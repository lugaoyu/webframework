package org.smart4j.proxy.joggle.impl.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类定义
 * 根据被代理类接口，动态生成代理类，并将实现InvocationHandler接口的类的引用放入生成的代理类中
 * 方法中调用该引用的invoke方法，传入相应的参数即可实现对目标方法的拦截增强
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.18
 */
public class DynomicCalculatorHandler implements InvocationHandler
{
    private Object object;
    public DynomicCalculatorHandler(Object object){
        this.object = object;
    }
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable
    {
        before();
        Object result = method.invoke(object, params);
        after();
        return result;
    }
    
    private void before()
    {
        System.out.println("调用目标方法增强前");
    }
    
    private void after()
    {
        System.out.println("调用目标方法增强后");
    }
}
