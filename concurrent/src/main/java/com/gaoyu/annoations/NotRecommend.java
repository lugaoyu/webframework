package com.gaoyu.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * ClassName: NotRecommend <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月27日 上午10:13:32 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend
{
        
}
