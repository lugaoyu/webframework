package org.smart4j.framework.proxy.springProxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * AOP测试代码
 * Spring AOP 前置增强
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-19
 */
public class HelloBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("前置增强");
	}
	
}
