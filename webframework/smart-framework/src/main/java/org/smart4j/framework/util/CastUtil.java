package org.smart4j.framework.util;

/**
 * 转型操作工具类
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-07-18
 */
public final class CastUtil {
	public static String castString(Object obj) {
		return castString(obj, "");
	}

	/**
	 * 转为String类型
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	public static double castDouble(Object obj) {
		return castDouble(obj, 0);
	}

	/**
	 * 转为Double类型
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj, double defaultValue) {
		double doubleValue = defaultValue;
		if (null != obj) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}

	public static long castLong(Object obj) {
		return castLong(obj, 0);
	}

	/**
	 * 转为long型(提供默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj, long defaultValue) {
		long longValue = defaultValue;
		if (null != obj) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					longValue = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}

	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}

	/**
	 * 转为int型(提供默认值)
	 * 
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj, int defaultValue) {
		int value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					value = defaultValue;
				}
			}
		}
		return value;
	}

	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}

	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean value = defaultValue;
		if (null != obj) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				value = Boolean.parseBoolean(strValue);
			}
		}
		return value;
	}
}
