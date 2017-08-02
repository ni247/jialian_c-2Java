package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;

public interface ICustomerDao {

	public List<Customer> getList(String queryName, String queryValue) throws Exception;

	public void delete(String id) throws Exception;

	public Customer getById(String id) throws Exception;

	public void saveOrUpdate(Customer c) throws Exception;

}
