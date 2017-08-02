package com.itheima.service;

import java.sql.SQLException;

import com.itheima.Dao.UserDao;

public class UserService {

	public int checkUsername(String name) throws SQLException {
		return new UserDao().checkUsername(name);
	}

}
