package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {

	public User getUser(User use) throws SQLException {
		return new UserDao().getUser(use);
	}

}
