package com.itheima.d_config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servletconfig对象的常用方法
 * @author Xbc
 *
 */
public class SConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取servletconfig
		ServletConfig config = getServletConfig();
		// 获取当前servlet名称
		System.out.println("servlet名称:" + config.getServletName());
		// 获取初始化参数
		System.out.println("user:" + config.getInitParameter("user"));
		System.out.println("psw:" + config.getInitParameter("password"));
		System.out.println("我是分隔符----------------------");
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements())
			System.out.println("名称:" + names.nextElement());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
