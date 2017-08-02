package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductsService;

/**
 * Servlet implementation class ShowProductsByPage
 */
public class ShowProductsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		try {
			PageBean<Product> pageBean = new ProductsService().getPageData(currPage, 2);
			request.setAttribute("pageData", pageBean);
			request.getRequestDispatcher("/product_page.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "数据查询失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
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
