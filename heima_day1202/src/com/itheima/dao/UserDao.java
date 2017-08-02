package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DatasSourceUtils;

public class UserDao {

	public User getUser(String userName, String password) {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		try {
			return qr.query(sql, new BeanHandler<>(User.class), userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
