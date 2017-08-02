package com.itheima.demo3;

public class CustomerServiceImpl {
	private CustomerDaoImpl customerDao;

	public void setCustomerDao(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	public void save() {
		System.out.println("服务层运行了");
		customerDao.save();
		System.out.println("运行完毕");
	}
}
