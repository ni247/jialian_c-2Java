package com.itheima.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyCglibUtils {
	/*
	 * 使用cglib方式生成代理对象
	 */
	public static BookDaoImpl getProxy() {
		Enhancer enhance = new Enhancer();
		// 设置父类
		enhance.setSuperclass(BookDaoImpl.class);
		// 设置回调函数
		enhance.setCallback(new MethodInterceptor() {
			// 代理对象的方法执行,回调函数就会执行
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				System.out.println("我增强了");
				// 注意使用这种方式执行主要方法
				return arg3.invokeSuper(arg0, arg2);
			}
		});
		return (BookDaoImpl) enhance.create();
	}
}
