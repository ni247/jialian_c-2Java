package com.itheima.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo4 {
	@Test
	public void run1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car1 c = (Car1) ac.getBean("car1");
		System.out.println(c);
	}

	@Test
	public void run2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person c = (Person) ac.getBean("person");
		System.out.println(c);
	}

	@Test
	public void run3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 c = (Car2) ac.getBean("car2");
		System.out.println(c);
	}

	/**
	 * 测试注入集合
	 */
	@Test
	public void run4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User c = (User) ac.getBean("user");
		System.out.println(c);
	}

	/**
	 * 加载多个配置文件
	 */
	@Test
	public void run5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext2.xml");
		User c = (User) ac.getBean("user");
		System.out.println(c);
	}

}
