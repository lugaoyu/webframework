package org.smart4j.framework.proxy.cglibProxy;

/**
 * AOP测试代码
 * 客户端(cglib 动态代理)
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-18
 */
public class Main {
	public static void main(String[] args){
		Hello hello = CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
		hello.say("lugaoyu");
	}
}
