package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * 
 * @author Administrator 2017/7/18
 */
public final class StringUtil {
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null != str) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	/**
	 * 判断字符串是否非空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static String[] splitString(String str, String pattern){
		return str.split(pattern);
	}
}
