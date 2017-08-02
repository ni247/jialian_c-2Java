package com.itheima.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

public class Demo2 {

	/**
	 * 聚合函数:count() sum() avg() max() min()
	 * 
	 */
	@Test
	public void run9() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("select count(*) from Linkman  ");

		System.out.println("=====================================");
		// 查询所有联系人的数量
		List<Number> list = query.list();
		// 通过下表取值
		long value = list.get(0).longValue();
		System.out.println(value);
		tr.commit();
		session.close();
	}

	/**
	 * 投影查询:只查询几个字段,不是所有字段
	 * 
	 */
	@Test
	public void run8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("select new  Linkman(  lkm_name,lkm_gender) from Linkman  ");

		System.out.println("=====================================");
		// List<Linkman> list = query.list();
		// 会错误,javabean无法封装成linkman
		// 只能封装成object[]数组
		List<Linkman> list = query.list();
		for (Linkman l : list) {
			System.out.println(l);
		}
		tr.commit();
		session.close();
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void run7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("select  lkm_name,lkm_gender from Linkman  ");

		System.out.println("=====================================");
		// List<Linkman> list = query.list();
		// 会错误,javabean无法封装成linkman
		// 只能封装成object[]数组
		List<Object[]> list = query.list();
		for (Object[] l : list) {
			System.out.println(Arrays.toString(l));
		}
		tr.commit();
		session.close();
	}

	/**
	 * 按条件查询
	 */
	@Test
	public void run5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// Query query = session.createQuery("from Linkman where lkm_gender=?
		// ");
		Query query = session.createQuery("from Linkman where lkm_gender= ? ");
		// query.setString(0, "男");
		// query.setString("a", "男");
		// 通用方法
		query.setParameter(0, "男");
		System.out.println("=====================================");
		List<Linkman> list = query.list();
		for (Linkman l : list) {
			System.out.println(l);
		}
		tr.commit();
		session.close();
	}

	/**
	 * 分页查询
	 * 需要注意 ,是从0开始
	 */
	@Test
	public void run4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Linkman order by lkm_id  ");
		query.setFirstResult(3);
		query.setMaxResults(3);
		System.out.println("=====================================");
		List<Linkman> list = query.list();
		for (Linkman l : list) {
			System.out.println(l);
		}
		tr.commit();
		session.close();
	}

	/**
	 * 排序查询
	 * 关键字是一样的,order by 属性 desc(asc)
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Linkman order by lkm_id  ");
		System.out.println("=====================================");
		System.out.println(query.list());
		tr.commit();
		session.close();
	}

	/**
	 * 起别名
	 */
	@Test
	public void run2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Linkman l");
		System.out.println("=====================================");
		System.out.println(query.list().size());
		tr.commit();
		session.close();
	}

	@Test
	public void run1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Linkman");
		System.out.println("=====================================");
		System.out.println(query.list().size());
		tr.commit();
		session.close();
	}
}
