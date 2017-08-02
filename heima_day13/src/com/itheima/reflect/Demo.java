package com.itheima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.itheima.domain.Person;
import com.itheima.domain.User;

public class Demo {
	@Test
	public void f1() throws Exception {
		// 1.获取class对象
		Class c = Class.forName("com.itheima.domain.Person");
		// 2.获取构造器

		// 带参构造器
		Constructor constructor = c.getConstructor(String.class, String.class);
		Person newInstance = (Person) constructor.newInstance("3", "2");

		// 空参
		Person newInstance2 = (Person) c.newInstance();
	}

	@Test
	public void f3() throws Exception, InvocationTargetException {
		Class c = Class.forName("com.itheima.domain.User");
		User newInstance2 = (User) c.newInstance();

		Method declaredMethod = c.getDeclaredMethod("eat", String.class);
		// 需要设置私有方法的可访问行
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(newInstance2, "222");
	}

	@Test
	public void f4() throws Exception, InvocationTargetException {
		Class c = Class.forName("com.itheima.domain.User");
		User newInstance2 = (User) c.newInstance();

		Method declaredMethod = c.getDeclaredMethod("sleep1", String.class);
		// 需要设置私有方法的可访问行
		declaredMethod.setAccessible(true);
		int d = (int) declaredMethod.invoke(newInstance2, "222");
		System.out.println(d);
	}
}
