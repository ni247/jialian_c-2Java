package com.itheima.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

/**
 * 测试hibernate框架
 * @author Administrator
 *
 */
public class Demo1 {

	/**
	 *测试查询的方法
	 */
	@Test
	public void testQuery() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		// 创建查询的接口
		Query query = session.createQuery("from Customer");
		// 查询所有的数据select * from 表
		List<Customer> list = query.list();
		for (Customer c : list)
			System.out.println(c);
		tr.commit();
		session.close();
	}

	/**
	 *测试session的添加或修改
	 *添加的话new一个对象
	 *修改的话必须先查询出来
	 */
	@Test
	public void testUpdateOrUpdate() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer customer = new Customer();
		// 注意,主键id不能自己设置.
		// customer.setCust_id(1L);
		customer.setCust_name("小苍");
		System.out.println(customer);
		session.saveOrUpdate(customer);
		tr.commit();
		session.close();
	}

	/**
	 *测试session的修改方法
	 *注意:删除或者修改,先查询再删除或者修改
	 *这个也必须加事务
	 */
	@Test
	public void testUpdate() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, 2L);
		System.out.println(customer);
		customer.setCust_name("小苍");
		session.update(customer);
		tr.commit();
		session.close();
	}

	/**
	 *测试session的都删除方法
	 *注意:删除或者修改,先查询再删除或者修改
	 *这个必须加事务
	 */
	@Test
	public void testDelete() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println(customer);
		session.delete(customer);
		tr.commit();
		session.close();
	}

	/**
	 * get(arg0,arg1),通过主键查询来查询一条记录
	 * arg0是查询javabean的class对象
	 * arg1是查询的主键的值
	 */
	@Test
	public void testGet() {
		Session session = HibernateUtils.getSession();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println(customer);
		session.close();
	}

	/**
	 * 测试工具类
	 */
	@Test
	public void testSave2() {
		// 3.创建session对象
		Session session = HibernateUtils.getSession();
		// 4.开启事务
		Transaction tr = session.beginTransaction();
		// 5.编写保存的代码
		Customer c = new Customer();
		c.setCust_name("测试阿道夫");
		c.setCust_level("2");
		c.setCust_phone("110");
		/* c.setCust_id(1L); */
		session.save(c);
		// 保存数据,操作对象就相当于数据库的表结构
		// 6.提交事务
		tr.commit();
		// 7.释放资源
		session.close();
	}

	/**
	 * 测试保存客户
	 */
	@Test
	public void testSave() {
		/**
		 * 1.先加载配置文件
		 * 2.创建SessionFactory对象,生成session(会话)对象
		 * 3.创建session对象
		 * 4.开启事务
		 * 5.编写保存的代码
		 * 6.提交事务
		 * 7.释放资源
		 */
		// 1.先加载配置文件
		Configuration config = new Configuration();
		// 默认加载src目录下的hibernate.cfg.xml的配置文件
		config.configure();
		// 手动加载
		// config.addResource("com/itheima/domain/Customer.hbm.xml");
		// 2. 创建sessionfactory对象
		SessionFactory factory = config.buildSessionFactory();
		// 3.创建session对象
		Session session = factory.openSession();
		// 4.开启事务
		Transaction tr = session.beginTransaction();
		// 5.编写保存的代码
		Customer c = new Customer();
		c.setCust_name("测试111145");
		c.setCust_level("2");
		c.setCust_phone("110");
		/* c.setCust_id(1L); */
		session.save(c);
		// 保存数据,操作对象就相当于数据库的表结构
		// 6.提交事务
		tr.commit();
		// 7.释放资源
		session.close();
		factory.close();
	}
}
