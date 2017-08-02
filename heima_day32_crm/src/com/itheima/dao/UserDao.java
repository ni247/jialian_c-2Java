package com.itheima.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;

public class UserDao {
	/**
	 * 通过用户名和密码查找用户
	 * @param user
	 * @return
	 */
	public User findByNameAndPwd(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		List<User> list = criteria.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}
}
