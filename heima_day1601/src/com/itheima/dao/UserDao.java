package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DatasSourceUtils;

public class UserDao {

	public User getUser(User use) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return qr.query(sql, new BeanHandler<>(User.class), use.getUsername(), use.getPassword());
	}

	public User getUser(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return qr.query(sql, new BeanHandler<>(User.class), username, password);
	}

}
