package org.smart4j.framework.proxy.springProxy.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Spring AOP 声明式配置
 * 增强类1
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-20
 */
public class HelloAroundAdvice1 implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		before1();
		Object result = invocation.proceed();
		after1();
		return result;
	}
	
	public void before1(){
		System.out.println("增强前1");
	}
	
	public void after1(){
		System.out.println("增强后1");
	}
}
