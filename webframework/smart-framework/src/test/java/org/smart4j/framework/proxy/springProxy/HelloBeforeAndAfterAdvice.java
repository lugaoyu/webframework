package org.smart4j.framework.proxy.springProxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * AOP测试代码
 * Spring AOP 增强类 同时实现前置增强和后置增强
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-19
 */
public class HelloBeforeAndAfterAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("后置增强1");
	}

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("前置增强1");
	}

}
