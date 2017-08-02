package com.itheima.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class UserService {
	public void save(User u1, User u2) {
		UserDao dao = new UserDao();
		// 这里获取session
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			dao.save1(u1);
			// int a = 10 / 0;
			dao.save2(u2);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			// 问题 session 关不关??
			// session可以不用关闭,线程结束了.自动关闭
			// session.close();
		}
	}
}
