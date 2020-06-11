package com.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//1111
import org.junit.Test;
//test
public class JDBCdemo1 {
	@Test
	public void demo() throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs= null;
		try {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
		//3.基本操作：执行SQL
		//3.1获得执行SQL语句的对象
		statement = conn.createStatement();
		//3.2编写SQL语句；
		String sql="select * from user";
		//3.3执行SQL
		rs = statement.executeQuery(sql);
		//3.4遍历结果集
		while(rs.next()) {
			System.out.print(rs.getInt("id")+" ");
			System.out.print(rs.getString("username")+" ");
			System.out.print(rs.getString("password")+" ");
			System.out.print(rs.getString("nickname")+" ");
			System.out.print(rs.getInt("age"));
			System.out.println();
		}
		}catch(Exception e) {
			e.printStackTrace();
	}finally {
		//释放资源
/*		conn.close();
		statement.close();
		rs.close();*/
		if(conn != null) {
			try {
			conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if(statement != null) {
			try {
				statement.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			statement = null;
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
}
