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

	/**
	 * 用户注册方法
	 * @param user
	 * @return
	 */
	public int regist(User user) {
		return new UserDao().addUser(user);
	}
}
