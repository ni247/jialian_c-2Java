package com.itheima.a_listener.c_attr;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttrLis implements ServletContextAttributeListener {

	@Override
	// 添加
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("在servletcontext中添加了一个属性,属性为:" + scab.getName());
	}

	@Override
	// 删除
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("在servletcontext删除了一个属性,属性为:" + scab.getName());
	}

	@Override
	// 替换
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("在servletcontext替换了一个属性,属性为:" + scab.getName());
	}

}
