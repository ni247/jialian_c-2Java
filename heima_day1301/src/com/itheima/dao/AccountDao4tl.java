package com.itheima.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DatasSourceUtils;
import com.itheima.utils.JdbcUtils;

public class AccountDao4tl {

	public void accountOut(String fromuser, String money) throws SQLException {
		Connection conn = null;
		java.sql.PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DatasSourceUtils.getConnection();
			String sql = "update account set money=money-? where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, money);
			st.setString(2, fromuser);
			int i = st.executeUpdate();
			System.out.println("出" + i);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatasSourceUtils.closeResource(st, rs);
		}
	}

	public void accountIn(String touser, String money) throws SQLException {

		Connection conn = null;
		java.sql.PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DatasSourceUtils.getConnection();
			String sql = "update account set money=money+? where name=?";
			st = conn.prepareStatement(sql);
			st.setString(1, money);
			st.setString(2, touser);
			int i = st.executeUpdate();
			System.out.println("入" + i);
		}  catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatasSourceUtils.closeResource(st, rs);
		}
	}

}
