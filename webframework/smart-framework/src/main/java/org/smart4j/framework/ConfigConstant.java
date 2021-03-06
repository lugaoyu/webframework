﻿package org.smart4j.framework;

/**
 * 提供相关配置项常量
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-07-31
 * 测试git2密码设置
 */
public interface ConfigConstant {
	String CONFIG_FILE = "smart.properties";

	String JDBC_DRIVER = "smart.framework.jdbc.driver";
	String JDBC_URL = "smart.framework.jdbc.url";
	String JDBC_USERNAME = "smart.framework.jdbc.username";
	String JDBC_PASSWORD = "smatr.framework.jdbc.password";

	String APP_BASE_PACKAGE = "smart.framework.app.base_package";
	String APP_JSP_PATH = "smart.framework.app.jsp_path";
	String APP_ASSET_PATH = "smart.framework.app.asset_path";
}
