package com.gaoyu.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 参数校验器
 * ClassName: ValidatorUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月22日 下午11:24:03 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class ValidatorUtil
{
        private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
        
        public static boolean isMobile(String src) {
                if(StringUtils.isEmpty(src)) {
                        return false;
                }
                Matcher m = mobile_pattern.matcher(src);
                return m.matches();
        }
        
        public static void main(String[] args)
        {
                System.out.println(isMobile("18912341234"));
                System.out.println(isMobile("1891234123"));
        }
}
