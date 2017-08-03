package com.itheima.demo2;

import org.junit.Test;

public class Demo2 {
	@Test
	public void run1() {
		BookDaoImpl dao = new BookDaoImpl();
		dao.save();
		dao.update();
		System.out.println("============================");
		BookDaoImpl proxy = MyCglibUtils.getProxy();
		proxy.save();
		proxy.update();
	}
}
