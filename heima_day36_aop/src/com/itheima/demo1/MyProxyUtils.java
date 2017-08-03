package com.itheima.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk的方式生成代理对象
 * 
 * @author Administrator
 *
 */
public class MyProxyUtils {

	public static IUserDao getProxy(final IUserDao dao) {
		IUserDao proxy = (IUserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
				dao.getClass().getInterfaces(), new InvocationHandler() {
					// 只要代理对象方法一执行,invoke就会执行一次
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("我是里面的invoke");
						return method.invoke(dao, args);
					}
				});
		// 返回代理对象
		return proxy;
	}
}
