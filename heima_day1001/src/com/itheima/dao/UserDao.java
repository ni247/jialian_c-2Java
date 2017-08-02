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
			User user = qr.query(sql, new BeanHandler<>(User.class), username, psw);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return
	 */
	public int addUser(User user) {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "insert into user(username,password,email,name,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
		try {
			return qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(),
					user.getSex(), user.getBirthday(), user.getHobby());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
