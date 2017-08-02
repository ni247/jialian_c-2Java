package cn.itcast.demo2;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbcutil.JDBCUtilsConfig;

public class QueryRunnerDemo {
	private static Connection conn = JDBCUtilsConfig.getConnection();
	private static QueryRunner qr = new QueryRunner();

	public static void main(String[] args) throws Exception {
		delete();
	}

	static void delete() throws SQLException {
		String sql = "delete from sort where sid=?";
		int row = qr.update(conn, sql, 5);
		System.out.println(row);
		DbUtils.closeQuietly(conn);
	}

	static void update() throws SQLException {
		String sql = "update sort set sname=?,sprice=?,sdesc=? where sid=?";
		Object[] params = { "花卉", 999, "非常好看的药", 4 };
		int row = qr.update(conn, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(conn);
	}

	static void insert() throws SQLException {
		String sql = "insert into sort (sname,sprice,sdesc) values (?,?,?)";
		//这个直接写参数,也可以写成一个Object数组
		int row = qr.update(conn, sql, "中文", 500, "4000");
		System.out.println(row);
		DbUtils.closeQuietly(conn);
	}
}
