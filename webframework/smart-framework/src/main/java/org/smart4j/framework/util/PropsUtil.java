package org.smart4j.framework.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性文件工具类
 * 
 * @author Administrator 2017/7/18
 */
public final class PropsUtil {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropsUtil.class);

	/**
	 * 加载属性文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName) {
		Properties props = null;
		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
			if (null == is) {
				throw new FileNotFoundException(fileName + " file is not found");
			}
			props = new Properties();
			props.load(is);
		} catch (Exception e) {
			LOGGER.error("load propertites file failure", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				LOGGER.error("close input stream failure", e);
			}
		}
		return props;
	}

	/**
	 * 获取字符型属性(默认值为空字符串)
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getString(Properties props, String key) {
		return getString(props, key, "");
	}

	/**
	 * 获取字符型属性(可指定默认值)
	 * 
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties props, String key,
			String defaultValue) {
		String value = defaultValue;
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		}
		return value;
	}

	/**
	 * 获取数值型属性(默认值为0)
	 * 
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(Properties props, String key) {
		return getInt(props, key, 0);
	}

	/**
	 * 获取数值型属性(可指定默认值)
	 * 
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(Properties props, String key, int defaultValue) {
		int value = defaultValue;
		if (props.containsKey(key)) {
			value = CastUtil.castInt(props.get(key));
		}
		return value;
	}

	/**
	 * 获取布尔值属性(默认值为false)
	 * 
	 * @param props
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties props, String key) {
		return getBoolean(props, key, false);
	}

	public static boolean getBoolean(Properties props, String key,
			boolean defaultValue) {
		boolean value = defaultValue;
		if (props.contains(key)) {
			value = CastUtil.castBoolean(props.get(key));
		}
		return value;
	}
}
