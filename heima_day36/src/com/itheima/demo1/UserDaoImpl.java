package com.itheima.demo1;

import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {

	@Override
	public void save() {
		System.out.println("保存客户");

	}

}
