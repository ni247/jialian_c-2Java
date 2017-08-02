package com.itheima.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatasSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	/**
	 * 获取数据源
	 * @return 连接池
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * 释放语句执行者
	 * @param conn 连接
	 * @param st 语句执行体
	 * @param rs 结果
	 */
	public static void closeResource(Connection conn, Statement st,
			ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * 释放语句执行者 
	 * @param st 语句执行者
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			st = null;
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
