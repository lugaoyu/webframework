package org.smart4j.framework.proxy.springProxy;

/**
 * AOP测试代码
 * 实现类(目标类)
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-15
 */
public class HelloImpl implements Hello {

	public void say(String name) {
		System.out.println("Hello! " + name);
	}
	
	public void sing(){
		System.out.println("Sing..........");
	}
}
