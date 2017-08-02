package com.itheima.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object attribute = session.getAttribute("user");
		if (attribute instanceof User) {
			User use = (User) attribute;
			User reUse = null;
			try {
				reUse = new UserService().getUser(use);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 密码错误,重新登录
			if (reUse == null) {
				request.setAttribute("用户名或密码错误", "msg");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
			// 正确,放行
			chain.doFilter(request, response);
			// 需要在给session加时间
		}
	}

	@Override
	public void destroy() {
	}

}
