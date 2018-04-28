package org.smart4j.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

/**
 * 接口代理类(jdk动态代理)
 * @author lWX379193
 * @since  1.0.1
 * @data   2017.08.21
 */
public class ProxyFactory
{
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler()
        {
            public Object invoke(Object proxy, Method method, Object[] methodParams) throws Throwable
            {
                System.out.println("增强前");
                Object returnValue = method.invoke(target, methodParams);
                System.out.println("增强后");
                return returnValue;
            }
        });
    }
}
