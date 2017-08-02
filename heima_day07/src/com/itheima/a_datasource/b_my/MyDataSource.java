package com.itheima.a_datasource.b_my;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import com.itheima.utils.JdbcUtils;

/**
 * 简易的连接池
 * @author Xbc
 *
 */
public class MyDataSource {
	private static LinkedList<Connection> pool = new LinkedList<>();
	static {
		// 初始化的时候需要放入3个连接
		for (int i = 0; i < 3; i++) {
			try {
				pool.add(JdbcUtils.getConnection());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 从连接池中获取连接
	public static Connection getConnection() {
		// 获取连接的时候需要判断list是否为空
		if (pool.isEmpty()) {
			try {
				pool.add(JdbcUtils.getConnection());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("从池中获取一个连接");
		return pool.removeFirst();
	}

	// 归还连接的方法
	public static void addBack(Connection conn) {
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}
