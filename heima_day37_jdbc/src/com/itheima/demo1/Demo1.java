package com.itheima.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 演示jdbc的模板类
 * 
 * @author Administrator
 *
 */
public class Demo1 {
	@Test
	public void run1() {
		// spring 内置了连接池,也可以不使用整合其他连接池使用
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring_day03");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		// 创建模板类
		JdbcTemplate template = new JdbcTemplate();
		// 设置连接池
		template.setDataSource(dataSource);
		// 完成操作
		template.update("insert into t_account values (null,?,?)", "冠希", 10000);

	}
}
