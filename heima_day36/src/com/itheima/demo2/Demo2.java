package com.itheima.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.demo1.IUserService;

//spring的整合junit测试.标记runwith属性及配置问你件属性contextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
	@Resource(name = "userService")
	private IUserService userService;

	@Test
	public void run1() {
		userService.sayHello();
	}
}
