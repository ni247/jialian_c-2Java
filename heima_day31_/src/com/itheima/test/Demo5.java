package com.itheima.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

/**
 * hql的多表的查询
 * @author Administrator
 *
 */
public class Demo5 {

	/**
	 * 解决数据的重复问题
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer c inner join fetch c.linkmans");
		List<Customer> list = query.list();
		// 手动解决,开发中都是使用这个
		Set<Customer> s = new HashSet<>(list);
		for (Customer c : s) {
			System.out.println(c);
		}
		transaction.commit();
	}

	/**
	 * 查询的客户,客户和联系人有关联
	 * 将数据封装到对象中
	 * 提供关键字:fetch 迫切连接
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer c inner join fetch c.linkmans");
		// 默认的返回值还是数组
		List<Customer> list = query.list();
		for (Customer c : list) {
			System.out.println(c);
		}
		transaction.commit();
	}

	/**
	 * 查询的客户,客户和联系人有关联
	 *内连接的查询 
	 *from 对象类名 inner join 对象类名.对象中含的集合
	 *查询的结果有问题
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer c inner join c.linkmans");
		// 默认的返回值还是数组
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		transaction.commit();
	}
}
