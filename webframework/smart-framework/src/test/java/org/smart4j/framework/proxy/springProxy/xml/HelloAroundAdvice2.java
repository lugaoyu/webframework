package org.smart4j.framework.proxy.springProxy.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * Spring AOP 声明式配置
 * 增强类2
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-20
 */
public class HelloAroundAdvice2 implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		before2();
		Object result = invocation.proceed();
		after2();
		return result;
	}

	public void before2(){
		System.out.println("增强前2");
	}
	
	public void after2(){
		System.out.println("增强后2");
	}
}
