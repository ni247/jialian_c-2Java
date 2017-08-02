package com.itheima.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

/**
 * 查询的策略
 * @author Administrator
 *
 */
public class Demo7 {

	/**
	 * fetch=subselect lazy=false
	 * 采用子查询的方式
	 * 不延迟加载
	 */
	@Test
	@SuppressWarnings("all")
	public void run6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		System.out.println("============");
		for (Customer customer2 : list) {
			System.out.println(customer2.getLinkmans().size());
		}
		transaction.commit();
	}

	/**
	 * fetch=subselect lazy=true
	 * 采用子查询的方式
	 * 默认延迟加载
	 */
	@Test
	@SuppressWarnings("all")
	public void run5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		System.out.println("============");
		for (Customer customer2 : list) {
			System.out.println(customer2.getLinkmans().size());
		}
		transaction.commit();
	}

	/**
	 * fetch=join lazy=false
	 * 默认采用的左外链接查询
	 */
	@Test
	public void run4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println("============");
		System.out.println(customer.getLinkmans().size());

		transaction.commit();
	}

	/**
	 * fetch=select lazy=extra
	 * extra 极其懒惰.测试例子.只会用聚合函数查询数量.
	 * Hibernate: 
	select
	    count(lkm_id) 
	from
	    cst_linkman 
	where
	    lkm_cust_id =?
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println("============");
		System.out.println(customer.getLinkmans().size());

		transaction.commit();
	}

	/**
	 * fetch=select lazy=false
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println("============");
		System.out.println(customer.getLinkmans().size());

		transaction.commit();
	}

	/**
	 * 默认值:fetch=select lazy=true
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println("============");
		System.out.println(customer.getLinkmans().size());

		transaction.commit();
	}
}
