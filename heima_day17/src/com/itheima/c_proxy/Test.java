package com.itheima.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		final QQ qq = new QQ();
		// qq.run();
		// qq.stop();
		Car qqProxy = (Car) Proxy.newProxyInstance(QQ.class.getClassLoader(), new Class[] { Car.class },
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						/*
						 * System.out.println(method.getName()); return
						 * method.invoke(qq, args);
						 */
						if ("run".equals(method.getName())) {
							System.out.println("run加速了");
						}
						return method.invoke(qq, args);
					}
				});

		qqProxy.run();
	}
}
