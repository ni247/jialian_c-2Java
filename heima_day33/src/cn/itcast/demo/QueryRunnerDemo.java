package cn.itcast.demo;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbcutils.JDBCUtils;

/*
 *  测试写好的工具类
 *  提供的是一个DataSource接口的数据源
 *  QueryRunner类构造函数,直接传递Datasource的实现类
 *  
 */
public class QueryRunnerDemo {

	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public static void main(String[] args) throws SQLException {
		select();
	}

	static void select() throws SQLException {
		String sql = "select * from sort";
		List<Sort> list = qr.query(sql, new BeanListHandler<Sort>(Sort.class));
		for (Sort sort : list)
			System.out.println(sort);
	}

	static void insert() throws SQLException {
		String sql = "insert into sort (sname,sprice,sdesc) values(?,?,?)";
		Object[] params = { "文具", 50, "儿童用品也很贵" };
		int row = qr.update(sql, params);
		System.out.println(row);

	}
}
