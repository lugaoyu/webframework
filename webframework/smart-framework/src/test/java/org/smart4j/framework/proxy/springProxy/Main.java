package org.smart4j.framework.proxy.springProxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * AOP测试代码
 * Spring AOP 客户端(编程式)
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-19
 */
public class Main {
	public static void main(String[] args){
		ProxyFactory proxyFactory = new ProxyFactory();//创建代理工厂
		proxyFactory.setTarget(new HelloImpl());//注入目标类对象
		proxyFactory.addAdvice(new HelloBeforeAdvice());//添加前置增强
		proxyFactory.addAdvice(new HelloAfterAdvice());//添加后置增强
		proxyFactory.addAdvice(new HelloBeforeAndAfterAdvice());
		proxyFactory.addAdvice(new HelloAroundAdvice());
		Hello hello = (Hello) proxyFactory.getProxy();//从工厂方法中获取代理
		hello.say("lugaoyu"); 
		hello.sing();
	}
}
