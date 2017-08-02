package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {

	public User getUser(String userName, String password) {
		return new UserDao().getUser(userName, password);
	}

}
