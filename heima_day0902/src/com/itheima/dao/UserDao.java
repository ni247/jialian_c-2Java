package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DatasSourceUtils;

public class UserDao {
	public User login(String username, String psw) {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		try {
			User user = qr.query(sql, new BeanHandler<>(User.class), username,
					psw);
			return user;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
