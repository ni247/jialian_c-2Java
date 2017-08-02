package com.itheima.b_request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6523917615811268974L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String value = req.getParameter("username");
		// 往浏览器回写数据
		// 如果需要写中文,需要特别设置
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("数据:" + value);
		System.out.println(value);
	}
}
