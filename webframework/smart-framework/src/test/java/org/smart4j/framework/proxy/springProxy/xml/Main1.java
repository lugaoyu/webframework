package org.smart4j.framework.proxy.springProxy.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP 声明式配置
 * 客户端(拦定特定方法)
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-20
 */
public class Main1 {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring1.xml");
		Hello helloProxy = (Hello) context.getBean("helloProxy");
		helloProxy.say("lugaoyu");
		System.out.println("*******************");
		helloProxy.sing();
		System.out.println("*******************");
		helloProxy.goodMorning("lugaoyu");
		System.out.println("*******************");
		helloProxy.goodNight("lugaoyu");
		
	}
}
