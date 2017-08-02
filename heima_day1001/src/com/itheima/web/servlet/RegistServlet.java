package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * 用户注册
 * @author Administrator
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码,,因为是post
		request.setCharacterEncoding("utf-8");
		// 1.封装数据
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			// 2.调用userservice.regist(user) 返回值:int
			int r = new UserService().regist(user);
			// 3.判断int 将信息请求转发msgservlet
			if (r == 1) {
				request.setAttribute("msg", "添加成功");
				request.getRequestDispatcher("/msg").forward(request, response);
			} else {
				request.setAttribute("msg", "添加失败");
				request.getRequestDispatcher("/msg").forward(request, response);
			}
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
