package com.gaoyu.miaosha.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义参数校验器(注解)
 * ClassName: IsMobile <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:24:24 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IsMobileValidator.class})
public @interface IsMobile
{
        boolean required() default true;
        
        String message() default "{手机号码格式有误}";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };
        
}
