package com.itheima.demo1;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class Demo1 {
	@Test
	public void run1() {
		IUserDao dao = new UserDaoImpl();
		dao.save();
		System.out.println("========================");

		// 使用工具类,获取代理对象
		IUserDao proxy = MyProxyUtils.getProxy(dao);

		proxy.save();

		proxy.update();
	}
}
