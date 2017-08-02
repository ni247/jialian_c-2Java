package com.itheima.a_annatation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
	private static Method[] declaredMethods;
	private static Annotation[] declaredAnnotations;

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 运行这个类的时候需要将测试类中带有@mytest执行

		// 获取字节码对象
		Class c = MyTestTest.class;
		Method[] declaredMethods = c.getDeclaredMethods();
		for (Method method : declaredMethods) {
			/*
			 * Annotation[] declaredAnnotations =
			 * method.getDeclaredAnnotations(); if (declaredAnnotations != null
			 * && declaredAnnotations.length > 0) { for (Annotation annotation :
			 * declaredAnnotations) { System.out.println(annotation); } }
			 */
			
			//判断方式是否有指定的注解
			if (method.isAnnotationPresent(MyTest.class))
				method.invoke(c.newInstance());
		}
	}
}
