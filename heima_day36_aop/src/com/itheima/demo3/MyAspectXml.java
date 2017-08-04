package com.itheima.demo3;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类:切入点+通知
 * 
 * @author Administrator
 *
 */
public class MyAspectXml {
	/**
	 * 通知(具体的增强)
	 */
	public void log() {
		System.out.println("记录日志");
	}

	/**
	 * 最终通知
	 */
	public void after() {
		// TODO Auto-generated method stub
		System.out.println("最终");
	}

	/**
	 * 后置通知
	 */
	public void afterReturn() {
		System.out.println("后置通知");
	}

	/**
	 * 环绕通知:方法执行之前和方法执行之后进行通知,默认情况下,目标对象的方法不能执行,需要手动让对象方法执行
	 * 主要用事务管理
	 */
	public void around(ProceedingJoinPoint jointPoint) {
		System.out.println("环绕通知1");
		try {
			jointPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("环绕通知2");

	}

}
