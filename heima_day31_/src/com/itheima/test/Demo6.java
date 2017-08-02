package com.itheima.test;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

/**
 *  演示的延迟加载,提升程序的性能
 * @author Administrator
 *
 */
public class Demo6 {

	/**
	 * 关联级别的延迟加载
	 * 默认是延迟加载
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
	 * 类级别的延迟加载
	 * 需要使用session.load(),默认情况使用的延迟加载
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.load(Linkman.class, 1L);
		System.out.println("============");
		System.out.println(linkman.getLkm_name());

		transaction.commit();
	}

	/**
	 * 类级别的延迟加载
	 * get方法默认不使用延迟加载
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Linkman linkman = session.get(Linkman.class, 1L);
		System.out.println("============");
		System.out.println(linkman.getLkm_name());

		transaction.commit();
	}

}
