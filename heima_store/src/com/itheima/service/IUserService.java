package com.itheima.service;

import com.itheima.domain.User;

public interface IUserService {

	void regest(User use) throws Exception;

	User active(String code) throws Exception;

	User login(String username, String password) throws Exception;

}
