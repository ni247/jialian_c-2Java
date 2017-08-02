package com.itheima.a_cookie.b_rem;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemServlet
 */
public class RemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		response.setContentType("text/html;charset=utf-8");
		// 获取指定名称的cookie
		Cookie c = getCookieByName("lastTime", request.getCookies());
		// 判断是否为空,
		if (c == null) {
			response.getWriter().print("第一次访问");
		} else {
			String value = c.getValue();
			long time = Long.parseLong(value);
			Date date = new Date(time);
			response.getWriter().print(date.toLocaleString());
		}
		c = new Cookie("lastTime", new Date().getTime() + "");
		c.setMaxAge(999999);
		response.addCookie(c);
	}

	private Cookie getCookieByName(String string, Cookie[] cookies) {
		if (cookies == null)
			return null;
		for (Cookie c : cookies) {
			if (c.getName() .equals(string))
				return c;
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
