package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 连接池jar包中,定义好一个类BasicDataSource
 * 实现类数据源的规范接口 javax.sql.DataSource
 */
public class DataSourceDemo {
	public static void main(String[] args) {
		//创建DataSource接口的实现类对象
		//实现类,org.apache.commons.dbcp
		BasicDataSource dataSource = new BasicDataSource();
		//基本信息是通过setXXX设置
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		try {
			Connection conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			//开发时,需要打印出错误详细信息
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败");
		}

	}

}
