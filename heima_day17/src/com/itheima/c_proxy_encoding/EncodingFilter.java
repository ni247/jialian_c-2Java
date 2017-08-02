package com.itheima.c_proxy_encoding;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpServletRequest reqProx = (HttpServletRequest) Proxy.newProxyInstance(
				HttpServletRequest.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						if ("getParameter".equals(method.getName())) {
							if ("get".equalsIgnoreCase(req.getMethod())) {
								String s = (String) method.invoke(req, args);
								return new String(s.getBytes("iso-8859-1"), "utf-8");
							} else if ("post".equalsIgnoreCase(req.getMethod())) {
								req.setCharacterEncoding("utf-8");
								return method.invoke(req, args);
							}
						}
						return method.invoke(req, args);
					}
				});
		chain.doFilter(reqProx, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
