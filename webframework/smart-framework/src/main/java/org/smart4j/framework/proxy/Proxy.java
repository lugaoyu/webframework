package org.smart4j.framework.proxy;

/**
 * 代理接口
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-10
 */
public interface Proxy {
	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
