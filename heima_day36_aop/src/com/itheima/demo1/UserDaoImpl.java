package com.itheima.demo1;

public class UserDaoImpl implements IUserDao {

	@Override
	public void save() {
		System.out.println("保存了");

	}

	@Override
	public void update() {
		System.out.println("更新了");

	}

}
