package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductsService;

/**
 * Servlet implementation class FindAllServlet
 */
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String key = request.getParameter("key");
		String productName = request.getParameter("productName");
		// if ("".equals(key) && "".equals(productName)) {
		List<Product> data = null;
		try {
			data = new ProductsService().findAll(key, productName);
			// getServletContext().setAttribute("allData", data);
			request.setAttribute("allData", data);
			request.getRequestDispatcher("/allData.jsp").forward(request, response);
			// response.sendRedirect(request.getContextPath() +
			// "/allData.jsp");
			// 这里需要注意,因为sendredirect跳转的话,原先的req,res声明周期到了.所以,放入req中的数据会失效.可以放入servletcontext中
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print("查询失败:失败原因" + e.getMessage());
		}
		// }
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
