package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.AccountService;
import com.itheima.service.AccountService4DB;
import com.itheima.service.AccountService4tl;

/**
 * 转账
 * @author Administrator
 *
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fromuser = request.getParameter("fromuser");
		String touser = request.getParameter("touser");
		String money = request.getParameter("money");
		try {
			// 使用的Threadlocal方式
			// new AccountService4tl().account(fromuser, touser, money);
			new AccountService4DB().account(fromuser, touser, money);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("转账失败");
			return;
		}
		response.getWriter().print("转账成功");
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
