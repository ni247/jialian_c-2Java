package com.itheima.demo2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 测试ioc的程序
 * @author Administrator
 *
 */
public class Demo2 {

	/**
	 * 原来的方式
	 */
	@Test
	public void run1() {
		UserService usi = new UserServiceImpl();
		usi.hello();
	}

	/**
	 * spring框架方式
	 */
	@Test
	public void run2() {
		// 创建工厂,加载核心配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从工厂获取到对象
		UserService usi = (UserService) ac.getBean("userService");
		// 执行对象的...

		usi.hello();
	}

	/**
	 * 老版本　ｂｅａｎＦａｃｔｏｒｙ
	 */
	@Test
	public void run4() {
		// 创建工厂,加载核心配置文件
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		// 从工厂获取到对象
		UserService usi = (UserService) factory.getBean("userService");
		// 执行对象的...

		usi.hello();
	}

	/**
	 * 演示销毁的方法
	 */
	@Test
	public void run5() {
		// 创建工厂,加载核心配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从工厂获取到对象
		UserService usi = (UserService) ac.getBean("userService");
		// 执行对象的...

		usi.hello();
		ac.close();
	}
}
