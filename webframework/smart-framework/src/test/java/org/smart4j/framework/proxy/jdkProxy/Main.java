package org.smart4j.framework.proxy.jdkProxy;

import java.lang.reflect.Proxy;

import org.smart4j.framework.proxy.staticProxy.Hello;
import org.smart4j.framework.proxy.staticProxy.HelloImpl;

/**
 * AOP测试代码
 * 客户端(jdk动态代理)
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-15
 */
public class Main {
	public static void main(String[] args){
		Hello hello = new HelloImpl();
		DynamicProxy dynamicProxy = new DynamicProxy(hello);
		Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy);
		helloProxy.say("lugaoyu");
		@SuppressWarnings("rawtypes")
		Class[] interfaces = {Hello.class};
		boolean result = ProxyUtils.saveProxyTargerClass("E:\\proxy.class", "HelloProxy", interfaces);
		System.out.println(result);
	}
}
