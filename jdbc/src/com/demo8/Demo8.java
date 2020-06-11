package com.demo8;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo8 {
	public static void main(String[] args) {
		Demo1();
	}
	public static void Demo1() {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3366/colb","root","123");
			String sql="insert into novel value(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 1);
			
			File file = new File("E:\\all.txt");			
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in,"UTF-8");
			pstm.setCharacterStream(2, reader,file.length());
			int count=pstm.executeUpdate();
			if(count>0) {
				System.out.println("操作成功");
			}
			else {
				System.out.println("操作失败");
			}
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
