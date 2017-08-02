package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

public class Demo1 {

	/**
	 * 
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Linkman l = session.get(Linkman.class, 1L);
		System.out.println("=====================================");
		System.out.println(l.getCustomer());
		tr.commit();
		session.close();
	}

	/**
	 * 
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println("=====================================");
		System.out.println(customer.getLinkmans().size());
		tr.commit();
		session.close();
	}
}
