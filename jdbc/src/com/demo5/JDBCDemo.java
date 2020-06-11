package com.demo5;
/**
 * SQL注入的漏洞
 * @author ASUS
 *
 */

import org.junit.Test;

public class JDBCDemo {
	@Test
	/**
	 * SQL注入漏洞的演示
	 */
	public void demo1() {
		UserDao userDao = new UserDao();
		boolean flag=userDao.login("aaa' or '1=1", "12asa3");
//		boolean flag=userDao.login("aaa' -- '", "12asa3");
		if(flag) {
			System.out.println("登录成功");
		}else {
			System.out.println("登陆失败");
		}
		}
	}


