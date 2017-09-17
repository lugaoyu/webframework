package org.smart4j.framework.proxy.cglibProxy;

/**
 * AOP测试代码
 * 实现类(目标类)
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-15
 */
public class HelloImpl implements Hello {

	public void say(String name) {
		System.out.println("Hello! " + name);
	}
}
