package com.itheima.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.dao.ICustomerDao;
import com.itheima.dao.ILinkmanDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.service.ILinkmanService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.HibernateUtils;

public class LinkmanServiceImpl implements ILinkmanService {

	@Override
	public List<Customer> addLinkmanUI() throws Exception {
		ICustomerDao dao = (ICustomerDao) BeanFactory.getBean("CustomerDao");
		return dao.getList(null, null);
	}

	@Override
	public boolean addLinkman(Linkman link, String cust_id) throws Exception {

		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			ILinkmanDao dao1 = (ILinkmanDao) BeanFactory.getBean("LinkmanDao");
			ICustomerDao dao2 = (ICustomerDao) BeanFactory.getBean("CustomerDao");
			Customer customer = dao2.getById(cust_id);
			link.setCustomer(customer);
			dao1.addLinkman(link);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public List<Linkman> getList(DetachedCriteria criteria) throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Linkman> list = null;
		try {
			ILinkmanDao dao = (ILinkmanDao) BeanFactory.getBean("LinkmanDao");
			list = dao.getList(criteria);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}
		return list;
	}

}
