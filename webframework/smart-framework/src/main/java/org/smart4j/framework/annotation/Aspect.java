    package org.smart4j.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切面注解
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @data 2017-08-10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * 注解
	 * @return
	 */
	Class<? extends Annotation> value();
}
