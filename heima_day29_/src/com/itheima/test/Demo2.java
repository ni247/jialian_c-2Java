package com.itheima.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class Demo2 {

	/**
	 * flush 手动刷新缓存,比对快照
	*/
	@Test
	public void run8() {
		try {
			Session session = HibernateUtils.getSession();
			Transaction tr = session.beginTransaction();
			User user1 = session.get(User.class, 1);
			System.out.println(user1.getName());
			session.flush();
			User user2 = session.get(User.class, 1);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * evict(obj) 清除指定的缓存
	*/
	@Test
	public void run7() {
		try {
			Session session = HibernateUtils.getSession();
			Transaction tr = session.beginTransaction();
			User user1 = session.get(User.class, 1);
			System.out.println(user1.getName());
			session.evict(user1);
			User user2 = session.get(User.class, 1);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * clear 清除所有的缓存
	*/
	@Test
	public void run6() {
		try {
			Session session = HibernateUtils.getSession();
			Transaction tr = session.beginTransaction();
			User user1 = session.get(User.class, 1);
			System.out.println(user1.getName());
			session.clear();
			User user2 = session.get(User.class, 1);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 快照机制
	*/
	@Test
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user = session.get(User.class, 1);
		user.setName("隔壁老王1");

		tr.commit();
		session.close();

	}

	/**
	 * 证明一级缓存的存在
	*/
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user = new User();
		user.setName("隔壁老王2");
		user.setAge(2);
		Serializable id = session.save(user);
		System.out.println("id" + id);

		// 获取对象,不会看到select,sql语句.所以是从缓存中存入的
		User user2 = session.get(user.getClass(), id);
		System.out.println(user.getName());

		tr.commit();
		session.close();

	}

	/**
	 * 持久化对象有自动更新数据库的能力
	*/
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user = session.get(User.class, 1);
		user.setName("隔壁老王1");
		tr.commit();
		session.close();

	}
}
