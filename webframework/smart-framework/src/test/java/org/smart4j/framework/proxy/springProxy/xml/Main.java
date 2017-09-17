package org.smart4j.framework.proxy.springProxy.xml;

import org.smart4j.framework.proxy.jdkProxy.ProxyUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP 声明式配置
 * 客户端
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-20
 */
public class Main {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
		Hello helloProxy = (Hello) context.getBean("helloProxy");
		helloProxy.say("lugaoyu");
		System.out.println("**************************");
		helloProxy.sing();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = {Hello.class};
		boolean result = ProxyUtils.saveProxyTargerClass("E:\\proxyTargetClass\\ProxyInterceptor.class", "HelloImpl", interfaces);
		System.out.println(result);
	}
}
