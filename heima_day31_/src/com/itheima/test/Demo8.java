package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

/**
 * 在 many-to-one标签上查询策略的优化
 * @author Administrator
 *
 */
public class Demo8 {

	/**
	 * 
	 * fetch:join
	 * lazy:不管什么值都一样
	 */
	@Test
	public void run4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.get(Linkman.class, 1L);
		System.out.println("==============");
		// 看联系人的客户名称
		System.out.println(linkman.getCustomer().getCust_name());
		transaction.commit();
	}

	/**
	 * 是否延迟加载由customer class配置 lazy属性决定
	 * fetch:select
	 * lazy:proxy
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.get(Linkman.class, 1L);
		System.out.println("==============");
		// 看联系人的客户名称
		System.out.println(linkman.getCustomer().getCust_name());
		transaction.commit();
	}

	/**
	 * 不延迟加载
	 * fetch:select
	 * lazy:false
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.get(Linkman.class, 1L);
		System.out.println("==============");
		// 看联系人的客户名称
		System.out.println(linkman.getCustomer().getCust_name());
		transaction.commit();
	}

	/**
	 * 默认值
	 * fetch:select
	 * lazy:true
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.get(Linkman.class, 1L);
		// 看联系人的客户名称
		System.out.println(linkman.getCustomer().getCust_name());
		transaction.commit();
	}
}
