package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
/*
 * JDBC中的CRUD的操作
 */
public class JDBCdemo2 {
	
	@Test
	/*
	 * 查询一条语句
	 */
	public void demo5() {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs= null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
			//执行SQL语句并编写
			//创建执行SQL语句的对象
			stm=conn.createStatement();
			//编写SQL语句
			String sql = "select * from user where id = 4 ";
			rs = stm.executeQuery(sql);
			//因为只有一条值使用直接判断就可以
			if(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("password")+" "+rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stm = null;
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
		}
	}
	
	@Test
	/*
	 * 查询代码的实现
	 */
	public void demo4() {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs= null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
			//执行操作
			stm=conn.createStatement();
			String sql = "select * from user";
			rs= stm.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("password")+" "+rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stm = null;
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
		}
	}
	
	
	@Test
	/*
	 * 删除代码的实现
	 */
	public void demo3() {
		Connection conn = null;
		Statement stm = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
			//执行SQL语句编写
			stm= conn.createStatement();
			//编写SQL语句
			String sql="delete from user where id=7";
			int num = stm.executeUpdate(sql);
			if(num > 0) {
				System.out.println("删除成功!!!");
			}else {
				System.out.println("删除失败!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stm = null;
			}
		}
	}
	
	
	
	@Test
	/*
	 * 修改代码的实现
	 */
	public void demo2() {
		Connection conn=null;
		Statement stm = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
			//基本操作执行SQl语句
			//获得SQL语句对象
			stm=conn.createStatement();
			//编写SQL语句
			String sql="update user set password='231',nickname='旺财' where id=5";
			int num = stm.executeUpdate(sql);
			if(num>0) {
				System.out.println("修改用户成功!!!");
			}else {
				System.out.println("修改用户失败!!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if(stm != null) {
				try {
					stm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stm = null;
			}
		}
	}
	
	
	
	@Test
	/*
	 * 保存操作的代码实现
	 */
	public void demo1() {
		Connection conn=null;
		Statement stmt=null;
		try {
			//加载驱动,注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3366/web_test3", "root", "123");
			//执行SQL
			//创建执行SQL语句对象
			stmt = conn.createStatement();
			//编写SQL语句
			String sql = "insert into user values(null,'eee','123','阿黄',21)";
			//执行SQL语句
			int num = stmt.executeUpdate(sql);
			if(num>0) {
				System.out.println("保存用户成功！！！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(conn !=null) {
				try {
				conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if(stmt != null) {
				try {
					stmt.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				stmt=null;
			}
		}
		
	}

}
