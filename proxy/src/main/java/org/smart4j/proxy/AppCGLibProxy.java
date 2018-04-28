package org.smart4j.proxy;

import org.smart4j.proxy.joggle.Hello;
import org.smart4j.proxy.joggle.impl.HelloImpl;

/**
 * 客户端(CGLib动态代理)
 * @author lWX379193
 * @since  1.0.0
 * @data   2017.08.10
 */
public class AppCGLibProxy
{
    public static void main(String[] args){
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("lwx3");
    }
}
