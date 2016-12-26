package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	// static语句块初始化字段信息
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("config.properties"));
			driver = properties.getProperty("driver").trim();
			url = properties.getProperty("url").trim();
			user = properties.getProperty("username").trim();
			pwd = properties.getProperty("password").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Connection con = null;
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		con =  DriverManager.getConnection(url, user, pwd);
		return con;
	}

	/**
	 * 关闭数据库连接
	 * @throws SQLException
	 */
	 public static void closeConnection() throws SQLException {
	        try {
	            if (null != con)
	                con.close();
	        } finally {
	            con = null;
	            System.gc();
	        }
	    }

	/**
	 * 根据sql语句查询
	 * @param con
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static List<Map<String, Object>> queryMapList(String sql) throws SQLException, InstantiationException,
			IllegalAccessException {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		Statement preStmt = null;
		ResultSet rs = null;
		try {
			preStmt = con.createStatement();
			rs = preStmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (null != rs && rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					String name = rsmd.getColumnName(i + 1);
					Object value = rs.getObject(name);
					map.put(name, value);
				}
				lists.add(map);
			}
		} finally {
			if (null != rs)
				rs.close();
			if (null != preStmt)
				preStmt.close();
		}
		return lists;
	}
	
	
	/**
	 * 带参数查询
	 * @param con
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	 public static List<Map<String, Object>> queryMapList(String sql, Object... params)
	            throws SQLException, InstantiationException, IllegalAccessException {
	        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
	        PreparedStatement preStmt = null;
	        ResultSet rs = null;
	        try {
	            preStmt = con.prepareStatement(sql);
	            for (int i = 0; i < params.length; i++)
	                preStmt.setObject(i + 1, params[i]);// 下标从1开始
	            rs = preStmt.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            while (null != rs && rs.next()) {
	                Map<String, Object> map = new HashMap<String, Object>();
	                for (int i = 0; i < columnCount; i++) {
	                    String name = rsmd.getColumnName(i + 1);
	                    Object value = rs.getObject(name);
	                    map.put(name, value);
	                }
	                lists.add(map);
	            }
	        } finally {
	            if (null != rs)
	                rs.close();
	            if (null != preStmt)
	                preStmt.close();
	        }
	        return lists;
	    }
	 
	/**
	 * 返回查询到的第一条数据
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> queryMap(String sql) {
		List<Map<String, Object>>  m = null;
		try {
			m=  queryMapList(sql);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m.get(0);
	}
	
	/**
	 * 带参数查询，并且返回查询到的第一条数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Map<String, Object> queryMap(String sql, Object...params) {
		List<Map<String, Object>>  m = null;
		try {
			m=  queryMapList(sql, params);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m.get(0);
		
	}

	/**
	 * 直接SQL语句更新
	 * 
	 * @param args
	 * @throws Exception
	 */

	 public static int execute(String sql) throws SQLException {
	        Statement stmt = null;
	        try {
	            stmt = con.createStatement();
	            return stmt.executeUpdate(sql);
	        } finally {
	            if (null != stmt)
	                stmt.close();
	        }
	    }
	  
	 /**
	  * 带参数的更新
	  * @param sql
	  * @param params
	  * @return
	  * @throws SQLException
	  */
	 public static int execute(String sql, Object... params) throws SQLException {
	        PreparedStatement preStmt = null;
	        try {
	            preStmt = con.prepareStatement(sql);
	            for (int i = 0; i < params.length; i++)
	                preStmt.setObject(i + 1, params[i]);// 下标从1开始
	            return preStmt.executeUpdate();
	        } finally {
	            if (null != preStmt)
	                preStmt.close();
	        }
	    }
	public static void main(String[] args) throws Exception {
		
		DBUtil.getConnection();
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));
		String sql2 = prop.getProperty("sqlForGetOtp_apply");
		System.out.println(DBUtil.queryMap(sql2, "15000801112").get("code"));	
	}
}
