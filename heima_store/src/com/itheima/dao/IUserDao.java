package com.itheima.dao;

import com.itheima.domain.User;

public interface IUserDao {

	void add(User use) throws Exception;

	User getByCode(String code) throws Exception;

	int updateByUser(User user) throws Exception;

	User getByUsernameAndPws(String username, String password) throws Exception;

}
