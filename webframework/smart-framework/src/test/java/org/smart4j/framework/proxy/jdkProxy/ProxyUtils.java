package org.smart4j.framework.proxy.jdkProxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * jdk动态代理 动态生成Java类
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-18
 */
@SuppressWarnings("restriction")
public class ProxyUtils {
	@SuppressWarnings({ "rawtypes" })
	public static boolean saveProxyTargerClass(String path,String proxyClassName,Class[] interfaces){
		if(proxyClassName == null || path == null){
			return false;
		}
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyClassName,interfaces);
		FileOutputStream out = null;
		try{
			out = new FileOutputStream(path);
			out.write(classFile);
			out.flush();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
