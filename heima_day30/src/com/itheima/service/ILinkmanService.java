package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;

public interface ILinkmanService {

	List<Customer> addLinkmanUI() throws Exception;

	boolean addLinkman(com.itheima.domain.Linkman link, String cust_id) throws Exception;

	List<Linkman> getList(DetachedCriteria criteria) throws Exception;

}
