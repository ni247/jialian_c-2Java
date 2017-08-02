package com.itheima.dao;

import org.hibernate.Session;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDao {
	public void saveOrUpdateCustoemr(Customer cus) {
		Session session = HibernateUtils.getCurrentSession();
		session.saveOrUpdate(cus);
	}
}
