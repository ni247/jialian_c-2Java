package com.itheima.service.Impl;

import java.util.List;

import com.itheima.dao.ICustomerDao;
import com.itheima.dao.Impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.utils.BeanFactory;

public class CustromerServiceImpl implements ICustomerService {

	@Override
	public List<Customer> getList(String queryName, String queryValue) throws Exception {
		ICustomerDao ic = (ICustomerDao) BeanFactory.getBean("CustomerDao");
		return ic.getList(queryName, queryValue);
	}

	@Override
	public void delete(String id) throws Exception {
		ICustomerDao ic = (ICustomerDao) BeanFactory.getBean("CustomerDao");
		ic.delete(id);
	}

	@Override
	public Customer getById(String id) throws Exception {
		ICustomerDao ic = (ICustomerDao) BeanFactory.getBean("CustomerDao");
		return ic.getById(id);
	}

	@Override
	public void saveOrUpdate(Customer c) throws Exception {
		ICustomerDao ic = (ICustomerDao) BeanFactory.getBean("CustomerDao");
		ic.saveOrUpdate(c);
	}
}
