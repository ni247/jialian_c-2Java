package com.itheima.a_datasource.e_dbcp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DbcpDemo {
	@Test
	public void f1() throws SQLException {
		BasicDataSource ds = new BasicDataSource();

		// 添加配置信息
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///day07");
		ds.setUsername("root");
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
		FileReader fr = new FileReader("jdbc.properties");
		Properties pro = new Properties();
		pro.load(fr);
		new BasicDataSourceFactory();
		// 创建连接池
		javax.sql.DataSource ds = BasicDataSourceFactory.createDataSource(pro);

		Connection conn = ds.getConnection();
		String sql = "select * from category";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next())
			System.out.println(rs.getString(1));
	}
}
