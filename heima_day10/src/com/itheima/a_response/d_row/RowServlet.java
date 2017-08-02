package com.itheima.a_response.d_row;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 操作请求行
 * @author Administrator
 *
 */
public class RowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求方式
		String method = request.getMethod();
		System.out.println("请求方式:" + method);
		// 获取请求参数的字符串
		String queryStr = request.getQueryString();
		System.out.println("请求参数:" + queryStr);
		// 获取请求的资源
		StringBuffer url = request.getRequestURL();
		System.out.println("带协议的完整路径(不包含参数):" + url);
		String uri = request.getRequestURI();
		System.out.println("项目名到参数前的内容:" + uri);
		// 获取协议版本
		String xieyi = request.getProtocol();
		System.out.println("协议:" + xieyi);
		// 获取请求的ip
		String ip = request.getRemoteAddr();
		System.out.println("ip:" + ip);
		// 获取项目名
		String xiangmu = request.getContextPath();
		System.out.println("项目名:" + xiangmu);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Auto-generated method stub
		doGet(request, response);
	}

}
