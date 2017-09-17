package org.smart4j.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.framework.util.ReflectionUtil;

/**
 * Bean 助手类
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-07
 */
public final class BeanHelper {
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
	/**
	 * 初始化Bean容器
	 */
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> beanClass : beanClassSet) {
			Object obj = ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}

	/**
	 * 获取Bean映射
	 * 
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
	
	/**
	 * 获取Bean实例
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls){
		if(!BEAN_MAP.containsKey(cls)){
			throw new RuntimeException("can not get bean by class:" + cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
	
	/**
	 * 设置Bean实例
	 * @param cls
	 * @param obj
	 */
	public static void setBean(Class<?> cls, Object obj){
		BEAN_MAP.put(cls, obj);
	}
}
