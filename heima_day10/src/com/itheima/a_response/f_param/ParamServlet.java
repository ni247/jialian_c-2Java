package com.itheima.a_response.f_param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取username
		String userName = request.getParameter("username");
		System.out.println("username:" + userName);
		// 获取多个值
		String[] parameterValues = request.getParameterValues("a");
		System.out.println("a:" + Arrays.toString(parameterValues));
		// 获取所有值
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet)
			System.out.println("键为" + key + ",值为:" + Arrays.toString(parameterMap.get(key)));
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
