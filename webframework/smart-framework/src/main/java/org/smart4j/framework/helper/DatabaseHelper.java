package org.smart4j.framework.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库操作助手类
 * 
 * @author lugaoyu
 * @since 1.0.0
 * @date 2017-08-13
 */
public final class DatabaseHelper {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DatabaseHelper.class);
	private static final String DRIVER = "com.jdbc.driver";
	private static final String URL = "jdbc:mysql://localhost:8080.demo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final ThreadLocal<Connection> containerConnection = new ThreadLocal<Connection>();

	/**
	 * 获取连接
	 * @return
	 */
	private static Connection getConnection(){
		Connection conn = containerConnection.get();
		if (null == conn) {
			try {
				try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e) {
					LOGGER.error("load jdbc driver failure"+ e);
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				LOGGER.error("get connection failure " + e);
				e.printStackTrace();
			} finally {
				containerConnection.set(conn);
			}
		}
		return conn;
	}

	/**
	 * 关闭连接
	 */
	public static void closeConnection() {
		Connection conn = containerConnection.get();
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOGGER.error("close connection failure " + e);
				e.printStackTrace();
			} finally {
				containerConnection.remove();
			}
		}
	}
	
	/**
	 * 开始事务
	 */
	public static void beginTrancation() {
		Connection conn = getConnection();
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				LOGGER.error("begin transaction failure",e);
				throw new RuntimeException();
			}finally{
				containerConnection.set(conn);
			}
		}
	}
	
	/**
	 * 提交事务
	 */
	public static void commitTransaction(){
		Connection conn = getConnection();
		if(conn != null){
			try{
				conn.commit();
				conn.close();
			}catch(SQLException e){
				LOGGER.error("commit transaction failure",e);
				throw new RuntimeException(e);
			}finally{
				containerConnection.remove();
			}
		}
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollbackTransaction(){
		Connection conn = getConnection();
		if(conn != null){
			try{
				conn.rollback();
				conn.close();
			}catch(SQLException e){
				LOGGER.error("rollback transaction failure",e);
				throw new RuntimeException(e);
			}finally{
				containerConnection.remove();
			}
		}
	}
}
