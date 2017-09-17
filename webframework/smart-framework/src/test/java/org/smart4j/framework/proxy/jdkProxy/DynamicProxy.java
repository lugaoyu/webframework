package org.smart4j.framework.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * AOP测试代码（jdk 动态代理）
 * 代理类实现接口InvocationHandler
 * 为目标类生成一个代理类，且该代理类中有DynamicProxy类的引用，调用该引用的invoke方法即可实现增强
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-15
 * 更新/该类就是一个增强类
 */
public class DynamicProxy implements InvocationHandler {
	private Object target; //目标类
	
	public DynamicProxy(Object target){
		this.target = target;
	}
	
	/**
	 * @param proxy
	 * @param method 该对象是动态生成的字节码中传入的
	 * @param args 参数
	 * @return Object
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	
	private void before(){
		System.out.println("调用方法增强前");
	}
	
	private void after(){
		System.out.println("调用方法增强后");
	}
}
