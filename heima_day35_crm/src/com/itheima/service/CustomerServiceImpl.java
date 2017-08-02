package com.itheima.service;

import com.itheima.dao.ICustomerDao;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao customerDao;

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save() {
		System.out.println("业务层,保存客户");
		customerDao.save();
	}

}
