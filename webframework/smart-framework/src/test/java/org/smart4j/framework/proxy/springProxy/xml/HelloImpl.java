package org.smart4j.framework.proxy.springProxy.xml;
/**
 * Spring AOP 声明式配置
 * 实现类
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-20
 */
public class HelloImpl implements Hello {

	public void say(String name) {
		System.out.println("hello: " + name);
	}

	public void sing() {
		System.out.println("hello: sing");
	}
	
	public void goodMorning(String name){
		System.out.println("Good Morning! " + name);
	}
	
	public void goodNight(String name){
		System.out.println("Good Night! " + name);
	}

}
