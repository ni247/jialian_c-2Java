package com.itheima.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 注解方式的切面类
 * 
 * @author Administrator
 *
 */
// 用@apspect注解切面类
@Aspect
public class MyAspctAnno {
	/**
	 * 通知类型:@Begore前置通知
	 */
	@Before(value = "MyAspctAnno.fn()")
	public void log() {
		System.out.println("记录日志");
	}

	/**
	 * 最终
	 */
	@After(value = "MyAspctAnno.fn()")
	public void after() {
		System.out.println("最终通知...");
	}

	/**
	 * 环绕通知
	 */
	@Around(value = "MyAspctAnno.fn()")
	public void around(ProceedingJoinPoint joinpoint) {
		System.out.println("环绕通知1");
		try {
			joinpoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("环绕通知2");
	}

	/**
	 * 自定义切入点
	 * 
	 */
	@Pointcut(value = "execution( * com.itheima.demo1.CustomerImpl.save())")
	public void fn() {

	}

}
