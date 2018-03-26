/**
 * Project Name:smart-springmvc
 * File Name:ResponseBody.java
 * Package Name:com.gaoyu.annotation
 * Date:2018年3月25日上午9:43:02
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**返回体注解
 * ClassName:ResponseBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年3月25日 上午9:43:02 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseBody
{
        
}

