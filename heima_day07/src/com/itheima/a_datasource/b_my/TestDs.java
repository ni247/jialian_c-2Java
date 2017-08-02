package com.itheima.a_datasource.b_my;

import java.sql.Connection;

public class TestDs {
	public static void main(String[] args) {
		// 获取连接
		Connection conn = MyDataSource.getConnection();
		System.out.println(conn);

		// 归还连接
		MyDataSource.addBack(conn);
	}
}
