package com.itheima.c_life;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet implements Servlet {

	/**
	 * 初始化方法
	 * 执行者:服务器
	 * 执行次数:1次
	 * 执行时机:默认第一次访问的时候
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * 服务方法
	 * 执行者:服务器
	 * 执行次数:请求一次,执行一次
	 * 执行时机:请求过来的时候执行
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("我是个service");

	}

	@Override
	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	/**
	 * 销毁方法
	 * 执行者:服务器
	 * 执行次数:只执行一次
	 * 执行时机:当servlet被移除或者服务器正常关闭的时候
	 */
	@Override
	public void destroy() {
		System.out.println("坏了啊");

		
	}

}
