package org.smart4j.framework.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

import org.smart4j.framework.proxy.staticProxy.Hello;

/**
 * jdk动态生成目标代理类 拦截类(不是拦截某个方法)
 * @author lugaoyu
 * @since    1.0.0
 * @data      2017-09-17
 */
public final class HelloProxy extends Proxy implements Hello {
	private static final long serialVersionUID = 1L;
	private static Method m1;
	private static Method m2;
	private static Method m3;
	private static Method m0;

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals",
					new Class[] { Class.forName("java.lang.Object") });
			m2 = Class.forName("java.lang.Object").getMethod("toString",
					new Class[0]);
			m3 = Class.forName("org.smart4j.framework.proxy.staticProxy.Hello")
					.getMethod("say",
							new Class[] { Class.forName("java.lang.String") });
			m0 = Class.forName("java.lang.Object").getMethod("hashCode",
					new Class[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HelloProxy(InvocationHandler paramInvocationHandler) {
		super(paramInvocationHandler);
	}

	/**
	 * h - DynamicProxy实例对象
	 */
	public final boolean equals(Object paramObject) {
		try {
			return ((Boolean) this.h.invoke(this, m1,
					new Object[] { paramObject })).booleanValue();
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final String toString() {
		try {
			return (String) this.h.invoke(this, m2, null);
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void say(String paramString) {
		try {
			this.h.invoke(this, m3, new Object[] { paramString });
			return;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final int hashCode() {
		try {
			return ((Integer) this.h.invoke(this, m0, null)).intValue();
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

}
