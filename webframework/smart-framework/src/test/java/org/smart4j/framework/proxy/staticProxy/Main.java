package org.smart4j.framework.proxy.staticProxy;

/**
 * AOP测试代码
 * 客户端
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-15
 */
public class Main {
	public static void main(String[] args){
		Hello helloProxy = new HelloProxy();
		helloProxy.say("lugaoyu");
	}
}
