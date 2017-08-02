package com.itheima.jquery_ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JqueryAjax
 */
public class JqueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getMethod());
		// request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(new String(username.getBytes("iso-8859-1"), "utf-8"));
		response.getWriter().print("success");
		System.out.println(request.getMethod());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getMethod());
		// request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("username"));
		String s = "{\"result\":\"success\",\"msg\":\"成功\"}";
		response.getWriter().print(s);
		System.out.println(request.getMethod());
	}

}
