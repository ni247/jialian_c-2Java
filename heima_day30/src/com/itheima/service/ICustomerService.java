package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

public interface ICustomerService {

	public List<com.itheima.domain.Customer> getList(String queryName, String queryValue) throws Exception;

	public void delete(String id) throws Exception;

	public com.itheima.domain.Customer getById(String id) throws Exception;

	public void saveOrUpdate(com.itheima.domain.Customer c) throws Exception;
}
