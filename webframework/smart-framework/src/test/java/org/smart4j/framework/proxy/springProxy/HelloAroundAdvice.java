package org.smart4j.framework.proxy.springProxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * AOP测试代码
 * Spring AOP 环绕增强，不需要同时实现两个接口
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-19
 */
public class HelloAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		before();
		Object result = invocation.proceed();
		after();
		return result;
	}

	private void before(){
		System.out.println("前置增强2");
	}
	
	private void after(){
		System.out.println("后置增强2");
	}
}
