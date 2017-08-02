package com.itheima.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo3 {

	/**
	 * spring方式
	 */
	@Test
	public void run2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerServiceImpl serviec = (CustomerServiceImpl) ac.getBean("customerService");
		serviec.save();
	}
}
