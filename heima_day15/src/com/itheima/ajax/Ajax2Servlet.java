package com.itheima.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ajax2Servlet
 */
public class Ajax2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		userName = new String(userName.getBytes("ISO8859-1"), "utf-8");
		// 这里,需要注意的是get请求下.对字符串进行的编码转换
		// 第一步,用iso8859-1对传过来的字符串,转换为字节数组
		/*
		 * byte[] b = userName.getBytes("ISO8859-1"); //
		 * 第二部.进字节数组,用utf-8编码转换为字符串 String name = new String(b, "utf-8");
		 */

		// 响应数据
		response.getWriter().print("姓名:" + userName);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getMethod());
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");

		response.getWriter().print("post姓名:" + userName);
	}

}
