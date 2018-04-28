package org.smart4j.proxy;

import java.lang.reflect.Proxy;

import org.smart4j.proxy.joggle.Hello;
import org.smart4j.proxy.joggle.impl.HelloImpl;

/**
 * 客户端(jdk动态代理)
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class AppDynamicProxy
{
    public static void main(String[] args)
    {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy =
            (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
        Hello helloProxy2 = dynamicProxy.getProxy();
        helloProxy.say("lwx");
        helloProxy2.say("lwx2");
    }
}
