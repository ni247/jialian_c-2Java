package com.itheima.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrivilegeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 业务逻辑
		Object obj = req.getSession().getAttribute("user");
		if (obj == null) {
			req.setAttribute("msg", "没有权限,请先登录");
			req.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
			return;
		}
		// 放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
