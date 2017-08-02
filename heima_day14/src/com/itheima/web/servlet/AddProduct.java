package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.itheima.domain.Product;
import com.itheima.service.ProductsService;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 扩展,令牌机制
		String stoke2 = request.getParameter("stoke");
		String stoke1 = (String) request.getSession().getAttribute("stoke");
		request.getSession().removeAttribute("stoke");
		if (!stoke2.equals(stoke1)) {
			request.setAttribute("msg", "已经保存");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		String pid = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Product product = new Product();
		try {
			BeanUtils.populate(product, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		product.setPid(pid);
		try {
			boolean r = new ProductsService().addProduct(product);
			response.getWriter().print(r ? "成功" : "失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//重定向
			// response.sendRedirect(request.getContextPath() + "/index.jsp");
			//请求转发
			request.getRequestDispatcher("/findAll").forward(request, response);
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
