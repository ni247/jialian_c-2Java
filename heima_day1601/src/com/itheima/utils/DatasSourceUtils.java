package com.itheima.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DatasSourceUtils {
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> tl = null;
	static {
		ds = new ComboPooledDataSource();
		tl = new ThreadLocal<>();
		try {
			tl.set(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据源
	 * @return 连接池
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 从当前线程上获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (tl.get() == null)
			tl.set(ds.getConnection());
		return tl.get();
	}

	/**
	 * 释放语句执行者
	 * @param conn 连接
	 * @param st 语句执行体
	 * @param rs 结果
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st, rs);
		closeConn(conn);
	}

	/**
	 * 释放语句执行者
	 * @param st 语句执行体
	 * @param rs 结果
	 */
	public static void closeResource(Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
	}

	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		getConnection().setAutoCommit(false);
	}

	/**
	 * 提交事务
	 */
	public static void commitAndCloseQuiety() {
		Connection con = null;
		try {
			con = getConnection();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(con);
		}

	}

	/**
	 * 回滚事务
	 */
	public static void rollbackAndCloseQuiety() {
		Connection con = null;
		try {
			con = getConnection();
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(con);
		}
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
				tl.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
