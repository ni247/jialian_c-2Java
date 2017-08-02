package com.itheima.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class UserService {
	public User login(User user) {
		// 注意,在业务层使用事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		User exotstUser = null;
		try {
			exotstUser = new UserDao().findByNameAndPwd(user);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return exotstUser;
	}

	@Test
	public void run() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("12345");
		User existUser = this.login(user);
		if (existUser != null) {
			System.out.println("登录成功了...");
		}
	}
}
