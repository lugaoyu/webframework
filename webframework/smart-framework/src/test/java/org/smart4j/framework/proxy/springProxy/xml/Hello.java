package org.smart4j.framework.proxy.springProxy.xml;
/**
 * Spring AOP 声明式配置
 * 接口
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-20
 */
public interface Hello {
	void say(String name);
	void sing();
	void goodMorning(String name);
	void goodNight(String name);
}
