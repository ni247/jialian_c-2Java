package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.BeanUtils;

import com.itheima.constant.Constant;
import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取参数
		User use = new User();
		try {
			BeanUtils.populate(use, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// service查询user
		User rUser = null;
		try {
			rUser = new UserService().getUser(use);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// a:rUser为空,返回错误信息
		if (rUser == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// b:rUser不为空,判断是否勾选自动登录
		String autoLogin = request.getParameter("autoLogin");

		// a:未勾选自动登录
		if (!Constant.IS_AUTO_LOGIN.equals(autoLogin)) {

		}
		// b:勾选自动登录,则往session中写入user,返回浏览器
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", rUser);
		}
		request.setAttribute("msg", "欢迎回来:" + use.getUsername());
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
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
