package com.gaoyu.miaosha.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.gaoyu.miaosha.util.ValidatorUtil;

/**
 * 参数校验器的校验方式
 * ClassName: IsMobileValidator <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:24:49 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class IsMobileValidator implements  ConstraintValidator<IsMobile,String>
{
        private boolean required = false;
        
        @Override
        public void initialize(IsMobile constraintAnnotation)
        {
                required = constraintAnnotation.required();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context)
        {
                if(required)
                {
                        return ValidatorUtil.isMobile(value);
                }
                else
                {
                        if(StringUtils.isEmpty(value))
                        {
                                return true;
                        }
                        else
                        {
                                return ValidatorUtil.isMobile(value);
                        }
                }
        }
}
