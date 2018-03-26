/**
 * Project Name:smart-springmvc
 * File Name:RequestMapping.java
 * Package Name:com.gaoyu.annotation
 * Date:2018年3月25日上午9:37:40
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**请求url到具体方法上的映射
 * ClassName:RequestMapping <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年3月25日 上午9:37:40 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping
{   
        public String value();
}

