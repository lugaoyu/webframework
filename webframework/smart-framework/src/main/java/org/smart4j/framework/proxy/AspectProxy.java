package org.smart4j.framework.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 切面代理
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-11
 */
public class AspectProxy implements Proxy {

	private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result = null;
		Class<?> cls = proxyChain.getTargetClass();
		Method method = proxyChain.getTargetMethod();
		Object[] params = proxyChain.getMethodParams();
		begin();
		try{
			if(intercept(cls,method,params)){
				before(cls,method,params);
				result = proxyChain.doProxyChain();
				after(cls,method,params,result);
			}else{
				result = proxyChain.doProxyChain();
			}
		}catch(Exception e){
			LOGGER.error("proxy failure",e);
			error(cls,method,params,e);
			throw e;
		}finally{
			end();
		}
 		return result;
	}
	
	public void begin(){
		
	}
	
	public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable{
		return true;
	}
	
	public void before(Class<?> cls, Method method, Object[] params) throws Throwable{
		
	}
	
	public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable{
		
	}
	
	public void error(Class<?> cls, Method method, Object[] params,Throwable e) {
		
	}
	
	public void end(){
		
	}
}
