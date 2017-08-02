package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public List<Customer> getList(String queryName, String queryValue) throws Exception {
		Session session = HibernateUtils.getSession();
		// 开启事务,一般在业务层开启
		Transaction tr = session.beginTransaction();
		// 创建查询接口
		// Query query = session.createQuery("from Customer");

		Criteria criteria = session.createCriteria(Customer.class);
		if (queryValue != null && queryValue.length() > 0)
			criteria.add(Restrictions.like(queryName, "%" + queryValue + "%"));
		List<Customer> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}

	@Override
	public void delete(String id) throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, Long.parseLong(id));
		session.delete(customer);
		tr.commit();
		session.close();
	}

	@Override
	public Customer getById(String id) throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer customer = session.get(Customer.class, Long.parseLong(id));
		tr.commit();
		session.close();
		return customer;
	}

	@Override
	public void saveOrUpdate(Customer c) throws Exception {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(c);
		tr.commit();
		session.close();
	}

}
