package com.itheima.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	/**
	 * 原来的方式
	 */
	@Test
	public void run1() {
		IUserService us = new UserServiceImp();
		us.sayHello();
	}

	/**
	 * 注解的方式
	 */ 
	@Test
	public void run2() {
		// 获取工厂记载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService us = (IUserService) ac.getBean("userService");
		us.sayHello();
	}
}
