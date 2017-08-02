package com.itheima.a_response.f_param;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Param_Servlet
 */
public class Param_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String psw = new String(request.getParameter("psw").getBytes("iso-8859-1"), "utf-8");
		username = URLDecoder.decode(request.getParameter("username"), "utf-8");
		psw = URLDecoder.decode(request.getParameter("psw"), "ios-8859-1");
		System.out.println("账号:" + username + "密码:" + psw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		System.out.println("账号:" + username + "密码:" + psw);
	}

}
