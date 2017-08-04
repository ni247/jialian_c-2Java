package com.itheima.demo3;

import javax.annotation.Resource;
import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class Demo3 {
	@Resource(name = "customerDao")
	private ICustomerDao customerDao;

	@Test
	public void run1() {
		customerDao.save();
		// customerDao.update();
	}
}
