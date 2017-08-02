package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;

public class Demo1 {

	/**
	 * 放弃外键的维护'
	 * 需求:让熊大联系人属于小风客户 
	 */
	@Test
	public void run11() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Customer customer = session.get(Customer.class, 1L);
			Linkman linkman = session.get(Linkman.class, 1L);
			// 解除
			customer.getLinkmans().remove(linkman);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解除关系:从集合中删除联系人,或者孤儿删除(直接就删除记录)
	 */
	@Test
	public void run10() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Customer customer = session.get(Customer.class, 1L);
			Linkman linkman = session.get(Linkman.class, 1L);
			// 解除
			customer.getLinkmans().remove(linkman);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除4
	 */
	@Test
	public void run9() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Linkman customer = session.get(Linkman.class, 1L);
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除3.删除联系人,级联删除客户
	 */
	@Test
	public void run8() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Linkman customer = session.get(Linkman.class, 1L);
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除2.删除客户,级联删除客户下的联系人
	 */
	@Test
	public void run7() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Customer customer = session.get(Customer.class, 1L);
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除1.联系人还在
	 */
	@Test
	public void run6() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			Customer customer = session.get(Customer.class, 1L);
			session.delete(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 级联保存:测试级联保存
	 */
	@Test
	public void run5() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// 保存客户和联系人的数据
			Customer c1 = new Customer();
			c1.setCust_name("美美");

			// 创建2个联系人
			Linkman l1 = new Linkman();
			l1.setLkm_name("熊大");
			Linkman l2 = new Linkman();
			l2.setLkm_name("熊二");

			// 使用联系人关联客户
			l1.setCustomer(c1);
			c1.getLinkmans().add(l2);

			session.save(l1);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 级联保存:保存联系人,级联客户
	 */
	@Test
	public void run4() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// 保存客户和联系人的数据
			Customer c1 = new Customer();
			c1.setCust_name("美美");

			// 创建2个联系人
			Linkman l1 = new Linkman();
			l1.setLkm_name("熊大");
			Linkman l2 = new Linkman();
			l2.setLkm_name("熊二");

			// 使用联系人关联客户
			l1.setCustomer(c1);
			l2.setCustomer(c1);

			session.save(l1);
			// 如果没有保存l2.

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 级联保存:保存客户,级联联系人
	 */
	@Test
	public void run3() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// 保存客户和联系人的数据
			Customer c1 = new Customer();
			c1.setCust_name("美美");

			// 创建2个联系人
			Linkman l1 = new Linkman();
			l1.setLkm_name("熊大");
			Linkman l2 = new Linkman();
			l2.setLkm_name("熊二");

			// 单向关联
			c1.getLinkmans().add(l1);
			c1.getLinkmans().add(l2);

			session.save(c1);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 单项关联的方式,如果不配置级联保存,程序出现异常
	 */
	@Test
	public void run2() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// 保存客户和联系人的数据
			Customer c1 = new Customer();
			c1.setCust_name("美美");

			// 创建2个联系人
			Linkman l1 = new Linkman();
			l1.setLkm_name("熊大");
			Linkman l2 = new Linkman();
			l2.setLkm_name("熊二");

			// 单向关联
			c1.getLinkmans().add(l1);
			c1.getLinkmans().add(l2);

			session.save(c1);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 最麻烦的双向关联的方式,保存数据
	 */
	@Test
	public void run1() {
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// 保存客户和联系人的数据
			Customer c1 = new Customer();
			c1.setCust_name("美美");

			// 创建2个联系人
			Linkman l1 = new Linkman();
			l1.setLkm_name("熊大");
			Linkman l2 = new Linkman();
			l2.setLkm_name("熊二");

			// 演示双向关联
			c1.getLinkmans().add(l1);
			c1.getLinkmans().add(l2);

			l1.setCustomer(c1);
			l2.setCustomer(c1);

			session.save(c1);
			session.save(l1);
			session.save(l2);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
