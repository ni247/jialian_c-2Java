package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1172181875424958862L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 0.设置编码
		// resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		// 这里注意先后逻辑问题
		// 1.接受用户名和密码
		String username = req.getParameter("username");
		String psw = req.getParameter("password");
		System.out.println(username);
		System.out.println(psw);
		// 2.调用userservice里的login(username,password) 返回值:User user
		User user = new UserService().login(username, psw);
		// 3.判断user是否为空
		if (user == null) {
			pw.print("111用户名和密码不匹配");
			resp.setHeader("refresh", "3;url=/day0901/login.htm");
		} else
			pw.print("1231欢迎回来");
		//

	}
}
