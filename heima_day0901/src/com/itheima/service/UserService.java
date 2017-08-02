package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	/**
	 * 用户登录
	 * @param username
	 * @param psw
	 * @return
	 */
	public User login(String username, String psw) {
		return new UserDao().login(username, psw);
	}
}
