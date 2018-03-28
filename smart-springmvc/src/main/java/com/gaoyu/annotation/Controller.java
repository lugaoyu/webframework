/**
 * Project Name:smart-springmvc
 * File Name:Controller.java
 * Package Name:com.gaoyu.annotation
 * Date:2018年3月25日上午9:28:20
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.gaoyu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

/**控制层注解
 * ClassName:Controller <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年3月25日 上午9:28:20 <br/>
 * @author   gaoyu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Documented
@Target(ElementType.TYPE)//该注解作用与类上
@Retention(RetentionPolicy.RUNTIME)//运行期获取注解上信息
public @interface Controller
{
}

