package com.itheima.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

/**
 * qbc的查询
 * @author Administrator
 *
 */
public class Demo3 {

	/**
	 *	
	 */
	@Test
	public void run10() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		// 创建离线条件查询的对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		// 添加查询的条件
		criteria.add(Restrictions.eq("lkm_gender", "男"));
		// 查询
		List<Linkman> list = criteria.getExecutableCriteria(session).list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * 聚合函数的查询
	 * 查了聚合函数后,又想查所有数据
	 */
	@Test
	public void run9() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		// 设置聚合函数的方式
		criteria.setProjection(Projections.count("lkm_id"));
		List<Number> list = criteria.list();
		long value = list.get(0).longValue();
		System.out.println(value);
		System.out.println("=====================");
		criteria.setProjection(null);
		List<Linkman> list1 = criteria.list();
		for (Linkman linkman : list1) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * 聚合函数的查询
	 */
	@Test
	public void run8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		// 设置聚合函数的方式
		criteria.setProjection(Projections.count("lkm_id"));
		List<Number> list = criteria.list();
		long value = list.get(0).longValue();
		System.out.println(value);
		System.out.println("=====================");
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * 判断值是否为空
	 */
	@Test
	public void run7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		criteria.add(Restrictions.or(Restrictions.isNull("lkm_email")));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * or查询
	 */
	@Test
	public void run6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		criteria.add(Restrictions.or(Restrictions.eq("lkm_gender", "女"), Restrictions.gt("lkm_id", 3L)));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * in查询
	 */
	@Test
	public void run5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		List<Long> pas = new ArrayList<>();
		pas.add(1L);
		criteria.add(Restrictions.in("lkm_id", pas));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * qbc条件查询
	 * eq
	 */
	@Test
	public void run4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		criteria.add(Restrictions.eq("lkm_gender", "男"));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * 分页查询方法,同hql相同
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		// 添加排序
		criteria.addOrder(Order.desc("lkm_id"));
		// 设置分页
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	/**
	 * 排序查询
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		// 添加排序
		criteria.addOrder(Order.desc("lkm_id"));
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}

	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Linkman.class);
		List<Linkman> list = criteria.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		transaction.commit();
	}
}
