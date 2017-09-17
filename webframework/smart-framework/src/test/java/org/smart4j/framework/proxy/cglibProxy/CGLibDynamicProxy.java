package org.smart4j.framework.proxy.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * AOP测试代码（cglib 动态代理）
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-18
 */
public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
	private CGLibDynamicProxy(){
		
	}
	public static CGLibDynamicProxy getInstance(){
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}
	
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(target, args);
		after();
		return result;
	}

	private void before(){
		System.out.println("Before");
	}
	
	private void after(){
		System.out.println("After");
	}
}
