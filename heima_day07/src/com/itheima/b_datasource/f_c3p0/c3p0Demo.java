package com.itheima.b_datasource.f_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Demo {

	@Test
	// 硬编码
	public void f1() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		// 设置基本参数
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///day07");
		ds.setUser("root");
		ds.setPassword("root");
		Connection conn = ds.getConnection();
		String sql = "select * from category";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next())
			System.out.println(rs.getString(1));
	}

	@Test
	public void f2() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "select * from category";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next())
			System.out.println(rs.getString(1));
	}
}
