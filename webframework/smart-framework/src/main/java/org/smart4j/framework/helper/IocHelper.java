package org.smart4j.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Autowired;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

/**
 * 依赖注入助手类
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-08
 */
public final class IocHelper {
	/**
	 * 初始化IOC容器,注入依赖对象
	 */
	static{
		Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
		if(CollectionUtil.isNotEmpty(beanMap)){
			//遍历Bean Map
			for(Map.Entry<Class<?>, Object> beanEntry: beanMap.entrySet()){
				//从BeanMap中获取Bean类与Bean实例
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				//获取Bean类定义的所有成员变量(简称Bean Field)
				Field[] beanFields = beanClass.getDeclaredFields();
				if(ArrayUtils.isNotEmpty(beanFields)){
					//遍历Bean Field
					for(Field beanField : beanFields){
						//判断当前Bean Field是否带有Autowired注解
						if(beanField.isAnnotationPresent(Autowired.class)){
							//在Bean Map中获取Bean Field对应的实例
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance != null){
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
