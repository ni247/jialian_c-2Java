package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.itheima.service.ProductsService;

/**
 * Servlet implementation class DeleteProduct
 */
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] arrayPid = request.getParameterValues("id");
		for (String id : arrayPid) {
			try {
				boolean r = new ProductsService().deleteProduct(id);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("msg", "数据错误");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect(getServletContext().getContextPath() + "/findAll");
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
