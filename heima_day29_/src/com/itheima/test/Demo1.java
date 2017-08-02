package com.itheima.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import com.sun.xml.internal.txw2.output.DumpSerializer;

public class Demo1 {
	/**
	 * 演示持久类对象的三个状态
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		// 持久user的对象
		// 瞬时态:没有oid,没有被session管理
		// 此时user对象是瞬时态对象
		User user = new User();
		user.setAge(19);
		user.setName("下彭泽");

		// 使用session保存用户
		// user对象中已经存在id的值,默认情况下,把user对象也保存到session的缓存中
		// 就是持久态对象了
		Serializable serializable = session.save(user);
		System.out.println("主键的值:" + serializable);
		tr.commit();
		session.close();
		// session销毁,缓存没有了
		System.out.println(user.getId());
		System.out.println(user.getName());

	}
}
