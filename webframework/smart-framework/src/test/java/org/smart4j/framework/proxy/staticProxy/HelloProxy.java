package org.smart4j.framework.proxy.staticProxy;

/**
 * AOP测试代码
 * 代理类实现用户自定义接口
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-15
 */
public class HelloProxy implements Hello{
	private Hello hello;
	
	public HelloProxy(){
		hello = new HelloImpl();
	}
	
	public void say(String name) {
		before();
		hello.say(name);
		after();
	}
	
	private void before(){
		System.out.println("调用方法增强前");
	}
	
	private void after(){
		System.out.println("调用方法增强后");
	}
	
}
