package com.demo4;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
 * JDBC的工具类
 */
public class JDBCUtils {
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	
	static {
//		//获取属性文件中内容
		Properties p=new Properties();
		try {
			p.load(new FileInputStream("src/db.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverClassName=p.getProperty("driverClassName");
		url=p.getProperty("url");
		username=p.getProperty("username");
		password=p.getProperty("password");
//		driverClassName = "com.mysql.jdbc.Driver";
//		url="jdbc:mysql://localhost:3366/web_test3";
//		username="root";
//		password="123";
	}
	/*
	 * 注册驱动
	 */
	public static void loadDriver() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
//	
	/*
	 * 获得连接
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			//将驱动一并注册
			loadDriver();
			//获得连接
			conn=DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 资源的释放
	 */
	public static void release(Statement stmt,Connection conn) {
		if(conn != null) {
			try {
			conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(stmt != null) {
			try {
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	public static void release(ResultSet rs,Statement stmt,Connection conn) {
		if(conn != null) {
			try {
			conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(stmt != null) {
			try {
				stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(rs != null) {
			try {
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
