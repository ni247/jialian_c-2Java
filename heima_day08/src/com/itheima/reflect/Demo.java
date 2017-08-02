package com.itheima.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

import com.itheima.domain.HelloMyServlet;

public class Demo {
	@Test
	// 调用空参的add方法
	public void f2() throws Exception {
		Class<?> c = Class.forName("com.itheima.domain.HelloMyServlet");
		// 通过字节码对象创建一个实例对象,空参.
		/*
		 * HelloMyServlet hms = (HelloMyServlet) c.newInstance(); hms.add();
		 * hms.add(3, 5);
		 */
		HelloMyServlet hms = (HelloMyServlet) c.newInstance();
		Method m = c.getMethod("add");
		// 这里第一个参数是调用方法的实例,第二个参数是该方法执行是需要执行的参数
		m.invoke(hms);
	}

	@Test
	// 调用有两个参数的add方法
	public void f4() throws Exception {
		Class<?> c = HelloMyServlet.class;
		// 通过字节码对象创建一个实例对象,空参.
		/*
		 * HelloMyServlet hms = (HelloMyServlet) c.newInstance(); hms.add();
		 * hms.add(3, 5);
		 */
		HelloMyServlet hms = (HelloMyServlet) c.newInstance();
		// Constructor<?> ccd = c.getConstructor(int.class);
		// HelloMyServlet ccdd = (HelloMyServlet) ccd.newInstance(2);
		Method m = c.getMethod("add", int.class, int.class);
		// 这里第一个参数是调用方法的实例,第二个参数是该方法执行是需要执行的参数
		m.invoke(hms, 1, 2);
	}
}
