package com.itheima.dao;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void save() {
		System.out.println("持久层:保存客户");
	}

}
