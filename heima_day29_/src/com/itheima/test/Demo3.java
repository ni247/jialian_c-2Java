package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class Demo3 {
	@Test
	public void run1() {
		try {
			Session session = HibernateUtils.getSession();
			Transaction tr = session.beginTransaction();

			User user = session.get(User.class, 1);
			user.setName("隔壁老王c111es");

			tr.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("1出错了");
		}

	}

	@Test
	public void run2() {
		try {
			Session session = HibernateUtils.getSession();
			Transaction tr = session.beginTransaction();

			User user = session.get(User.class, 1);
			user.setAge(911199);

			tr.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("1出错了");
		}

	}
}
