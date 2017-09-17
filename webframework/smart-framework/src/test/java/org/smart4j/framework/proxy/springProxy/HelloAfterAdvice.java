package org.smart4j.framework.proxy.springProxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * AOP测试代码
 * Spring AOP 后置增强
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-19
 */
public class HelloAfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("后置增强");
	}
	
}
