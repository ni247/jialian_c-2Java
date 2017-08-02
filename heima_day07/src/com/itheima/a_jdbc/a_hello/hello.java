package com.itheima.a_jdbc.a_hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.utils.JdbcUtils;

public class hello {
	@Test
	public void f1() {
		System.out.println("hello");
	}

	@Test
	public void f2() throws Exception {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接 注意这个connection是java.sql中的
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day07", "root", "root");
		// 编写sql
		String sql = "select * from category";
		// 创建语句执行者
		PreparedStatement st = conn.prepareStatement(sql);
		// 设置参数

		// 执行sql
		ResultSet rs = st.executeQuery();
		// 处理结果
		while (rs.next()) {
			System.out.println(rs.getString("cid") + "::"
					+ rs.getString("cname"));
		}
		// 释放资源
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void f3() {
		// 外部声明变量,方便fanilly中释放资源
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			conn = JdbcUtils.getConnection();
			// 编写sql ?这里参数不需要''???
			String sql = "insert into category values(?,?)";
			// 获取语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数 ,这里注意,索引从1开始
			st.setString(1, "c0091");
			st.setString(2, "户外");
			// 执行操作
			int row = st.executeUpdate();
			if (row == 1)
				System.out.println("执行成功");
			else
				System.out.println("执行失败");
			// 处理结果
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
}
