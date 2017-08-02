package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.dao.ILinkmanDao;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

public class LinkmanDaoImpl implements ILinkmanDao {

	@Override
	public boolean addLinkman(Linkman link) throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		session.saveOrUpdate(link);
		return true;
	}

	@Override
	public List<Linkman> getList(DetachedCriteria criteria) throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		return criteria.getExecutableCriteria(session).list();
	}

}
