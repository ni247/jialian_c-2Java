package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");

		// 接受两个验证码
		String checkCode1 = request.getParameter("checkCode").toUpperCase();
		String checkCode2 = (String) request.getSession().getAttribute("sessionCode");
		// 用完之后从session中移除
		request.getSession().removeAttribute("sessionCode");
		if (checkCode1 == null || checkCode2 == null || !checkCode1.equals(checkCode2)) {
			// 验证码有问题,提示信息,页面跳转到login.jsp
			request.setAttribute("msg", "验证码错误,请重新输入验证码");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 接受用户名和明码
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		// 调用userservice 返回user
		User user = new UserService().getUser(userName, password);
		// 4判断user
		if (user == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			// 判断是否勾选了记住用户名
			String isSave = request.getParameter("isSave");
			if ("1".equals(isSave)) {
				Cookie c = new Cookie("userName", userName);
				c.setPath(request.getContextPath() + "/");
				c.setMaxAge(3600);
				response.addCookie(c);
			}
			// 用user放入session
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
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
