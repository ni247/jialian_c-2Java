package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//alt shift +a 块编辑
public class JdbcUtils {
	public static final String CLASS_NAME;
	public static final String URL;
	public static final String USER;
	public static final String PASSWORD;

	static {

		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		CLASS_NAME = rb.getString("classname");
		URL = rb.getString("url");
		USER = rb.getString("user");
		PASSWORD = rb.getString("password");

		/*FileReader read = null;
		try {
			read = new FileReader("jdbc.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties pro = new Properties();
		try {
			pro.load(read);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
				read = null;
			}
		}
		
		CLASS_NAME = pro.getProperty("classname");
		URL = pro.getProperty("url");
		USER = pro.getProperty("user");
		PASSWORD = pro.getProperty("password");*/

		try {
			Class.forName(CLASS_NAME);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
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
