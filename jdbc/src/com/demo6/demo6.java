package com.demo6;
/*
 * JDBC的DRUD的操作：PreparedStatement对象
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.demo4.JDBCUtils;

public class demo6 {
	@Test
	/*
	 * 查询操作
	 */
	public void demo4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			//获得连接
			conn=JDBCUtils.getConnection();
			//编写SQL语句
			String sql="select * from user where id= ?";
			//预编译
			pstmt=conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, 5);
			//执行SQL语句
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("username")+" "+rs.getString("nickname")+" "+rs.getString("password")+" "+rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
	}
	
	@Test
	/*
	 * 删除操作
	 */
	public void demo3() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//编写SQL语句
			String sql = "delete from user where id =?";
			//预编译SQL语句
			pstmt=conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, 1);
			//执行SQL语句
			int num=pstmt.executeUpdate();
			if(num>0) {
				System.out.println("删除成功!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}
	
	@Test
	/*
	 * 修改操作
	 */
	public void demo2() {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
			//获得连接
			conn=JDBCUtils.getConnection();
			//编写SQL语句
			String sql = "update user set password = ?,nickname= ? where id= ?";
			//预编译SQL语句
			pstmt=conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, "1234");
			pstmt.setString(2, "大白");
			pstmt.setInt(3, 10);
			//执行SQL语句
			int num=pstmt.executeUpdate();
			if(num>0) {
				System.out.println("修改用户成功!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}
	
	
	@Test
	/*
	 * 保持操作
	 */
	public void demo1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//获得连接
			conn=JDBCUtils.getConnection();
			//编写SQL语句
			String sql = "insert into user values (null,?,?,?,?)";
			//预编译SQL语句
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, "www");
			pstmt.setString(2, "213");
			pstmt.setString(3, "阿白");
			pstmt.setInt(4, 10);
			//执行SQL语句
			int num=pstmt.executeUpdate();
			if (num>0) {
				System.out.println("添加成功!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}
}
