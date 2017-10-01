package org.smart4j.framework.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.PropsUtil;

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
	private static final ThreadLocal<Connection> CONTAINER_CONNECTION;
	private static final BasicDataSource DATASOURCE;
	private static final QueryRunner QUERY_RUNNER;
	
	static{
		CONTAINER_CONNECTION = new ThreadLocal<Connection>();
		QUERY_RUNNER = new QueryRunner();
		DATASOURCE = new BasicDataSource();
		Properties conf = PropsUtil.loadProps("config.properties");
		String driver = conf.getProperty("jdbc.driver");
		String url = conf.getProperty("jdbc.url");
		String username = conf.getProperty("jdbc.username");
		String password = conf.getProperty("jdbc.password");
		DATASOURCE.setDriverClassName(driver);
		DATASOURCE.setUrl(url);
		DATASOURCE.setUsername(username);
		DATASOURCE.setPassword(password);
	}

	/**
	 * 获取连接
	 * @return
	 */
	private static Connection getConnection(){
		Connection conn = CONTAINER_CONNECTION.get();
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
				CONTAINER_CONNECTION.set(conn);
			}
		}
		return conn;
	}

	/**
	 * 关闭连接
	 */
	public static void closeConnection() {
		Connection conn = CONTAINER_CONNECTION.get();
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOGGER.error("close connection failure " + e);
				e.printStackTrace();
			} finally {
				CONTAINER_CONNECTION.remove();
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
				CONTAINER_CONNECTION.set(conn);
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
				CONTAINER_CONNECTION.remove();
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
				CONTAINER_CONNECTION.remove();
			}
		}
	}
	
	/**
	 * 查询实体列表
	 * @param entityClass 返回的实体类型
	 * @param sql 待执行的sql语句
	 * @param params 参数
	 * @return
	 */
	public static <T> List<T> queryEntityList(Class<T> entityClass,String sql,Object... params){
			List<T> entityList;
			try{
				Connection conn = getConnection();
				entityList =   QUERY_RUNNER.query(conn, sql, new BeanListHandler<T> (entityClass), params);
			}
			catch(SQLException e){
				LOGGER.error("query entity list failure",e);
				throw new RuntimeException(e);
			}
			return entityList;
	}
	
	/**
	 * 查询单个实体
	 * @param entityClass 返回的实体类型
	 * @param sql 待执行的sql语句
	 * @param params 参数
	 * @return
	 */
	public static <T> T queryEntity(Class<T> entityClass, String sql, Object...params){
		T entity;
		try{
			Connection conn = getConnection();
			entity = QUERY_RUNNER.query(conn, sql,new BeanHandler<T>(entityClass), params);
		}catch(SQLException e){
			LOGGER.error("query entity failure",e);
			throw new RuntimeException(e);
		}
		return entity;
	}
	
	/**
	 * 执行查询语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String,Object>> excuteQuery(String sql, Object... params){
		List<Map<String,Object>> result;
		try{
			Connection conn = getConnection();
			result = QUERY_RUNNER.query(conn ,sql, new MapListHandler(), params);
		}catch(SQLException e){
			LOGGER.error("excute query failure",e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * 执行更新语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object...params){
		int rows = 0;
		try{
			Connection conn = getConnection();
			rows = QUERY_RUNNER.update(conn, sql, params);
		}catch(SQLException e){
			LOGGER.error("execute update failure",e);
			throw new RuntimeException(e);
		}
		return rows;
	}
	
	/**
	 * 新增实体
	 * @param entityClass
	 * @param fieldMap
	 * @return
	 */
	public static<T> boolean insertEntity(Class<T> entityClass, Map<String,Object> fieldMap){ 
			if(CollectionUtil.isEmpty(fieldMap)){
				LOGGER.error("can not insert entity: fieldMap is empty");
				return false;
			}
			
			String sql = "insert into" + getTableName(entityClass);
			StringBuilder columns = new StringBuilder("(");
			StringBuilder values = new StringBuilder("(");
			for(String column : fieldMap.keySet()){
				columns.append(column).append(","); //insert into tablename(column1,column2,column3)values(?,?,?);
				values.append("?,");
			}
			columns.replace(columns.lastIndexOf(","), columns.length(), ")");
			values.replace(values.lastIndexOf(", "), columns.length() , ")");
			sql += columns + "values " + values;
			Object[] params = fieldMap.values().toArray();
			return executeUpdate(sql,params) == 1;
	}
	
	/**
	 * 更新实体
	 * @param entityClass
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public static<T> boolean updateEntity(Class<T> entityClass,long id, Map<String, Object> fieldMap){
		if(CollectionUtil.isEmpty(fieldMap)){
			LOGGER.error("can not update entity: fieldMap is empty");
			return false;
		}
		
		String sql = "update" + getTableName(entityClass); //update tablename set column1 = ?,column2 = ? where id = ?;
		StringBuilder columns = new StringBuilder();
		for(String fieldName : fieldMap.keySet()){
			columns.append(fieldName).append("=?,");
		}
		sql += columns.substring(0, columns.lastIndexOf(",")) + "where id=?";
		Object[] params = fieldMap.values().toArray();
		return executeUpdate(sql, params) == 1;
	}
	
	/**
	 * 删除实体
	 * @param entityClass
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public static<T> boolean deleteEntity(Class<?> entityClass,long id, Map<String, Object> fieldMap){
		if(CollectionUtil.isEmpty(fieldMap)){
			LOGGER.error("can not delete entity: fieldMap is empty");
			return false;
		}
		
		String sql = "delete from"  + getTableName(entityClass) + "where id=?"; //delete from tablename where id = "";
		return executeUpdate(sql, id) == 1;
	}
	
	/**
	 * 根据实体类获取表名称
	 * @param entityClass
	 * @return
	 */
	public static String getTableName(Class<?> entityClass)
	{
		return entityClass.getSimpleName();
	}
}
