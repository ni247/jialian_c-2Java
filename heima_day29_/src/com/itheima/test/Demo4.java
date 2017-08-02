package com.itheima.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class Demo4 {

	/**
	 * criteria接口,按条件查询
	 */
	@Test
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		// 添加查询条件
		// Criterion是hibernate提供的条件查询的对象.想传入条件的使用的工具类Restrictions
		criteria.add(Restrictions.gt("age", 2));
		// gt大于
		// like 模糊查询
		// Restrictions提供的静态方法,拼接查询的条件
		criteria.add(Restrictions.like("name", "%老%"));
		List<User> list = criteria.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	/**
	 * criteria接口,条件查询,非常适合
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> list = criteria.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from User where name like :name");
		query.setString("name", "%王%");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from User where name like ?");
		query.setString(0, "%王%");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}

	@Test
	public void run() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from User where age >?");
		query.setInteger(0, 2);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
}
