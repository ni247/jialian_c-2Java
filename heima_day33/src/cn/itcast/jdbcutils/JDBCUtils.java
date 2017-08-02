package cn.itcast.jdbcutils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//对象连接池的连接数量配置
		dataSource.setInitialSize(10);//初始化的连接数
		dataSource.setMaxActive(8); //最大连接数量
		dataSource.setMaxIdle(5);//最大空闲
		dataSource.setMinIdle(1); //最小空闲
	}

	//定义静态方法,返回basicDatasource类对象
	//能反接口.可以实现多态
	public static DataSource getDataSource() {
		return dataSource;
	}
}
