package com.itheima.a_response.b_body;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 操作响应体
 * @author Administrator
 *
 */
public class PrintSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应体中文编码.推荐使用这种写法
		response.setContentType("text/html;charset=utf-8");
		// response.setHeader("content-type", "text/html;charset=UTF-8");

		// 需要注意这样子谷歌浏览器不行.ie不行
		// response.setCharacterEncoding("utf-8");

		/*
		 * PrintWriter wr = response.getWriter(); wr.print(
		 * "<table border='1'><tr>"); wr.print("<td>我是表格啦啦啦<td><tr></table>");
		 */
		System.out.println("我是分隔符");
		// ServletOutputStream outputStream = response.getOutputStream();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
