package com.itheima.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Class<? extends BaseServlet> runClass = this.getClass();
		String methodName = request.getParameter("method");
		if (methodName == null)
			methodName = "index";
		String uri = null;
		try {
			Method method = runClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			uri = (String) method.invoke(this, request, response);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			// "404"
			// response.sendRedirect(getServletContext().getContextPath() +
			// CCommonConstant.ERROR_PAGE);
			return;
		} catch (Exception e) {
			// 发生错误,
			// 500
			e.printStackTrace();
			throw new RuntimeException();
		}
		if (uri != null && uri.length() > 0)
			request.getRequestDispatcher(uri).forward(request, response);
	}
}
