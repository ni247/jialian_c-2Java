package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CCartConstant;
import com.itheima.constant.CCommonConstant;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.service.IProductService;
import com.itheima.utils.BeanFactory;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public Cart getCart(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(CCartConstant.CART_ATTR);
		Cart cart;
		if (obj == null) {
			cart = new Cart();
			request.getSession().setAttribute(CCartConstant.CART_ATTR, cart);
		} else
			cart = (Cart) obj;
		return cart;
	}

	/**
	 * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		// System.out.println(pid + "_" + count);
		// 组成成item
		IProductService ps = (IProductService) BeanFactory.getBean("ProductService");
		Product product = ps.getById(pid);
		CartItem item = new CartItem(product, Integer.parseInt(count));
		// 添加到购车车中
		Cart cart = getCart(request);
		cart.add2Cart(item);
		// 重定向
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		return null;
	}

	/**
	 * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);
		cart.removeFromCart(pid);
		// 重定向
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		return null;
	}

	/**
	 * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String clear(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cart cart = getCart(request);
		cart.clearCart();
		// 重定向
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		return null;
	}

	public String cartUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "未登录,请登录后在操作");
			return CCommonConstant.LOGIN_PAGE;
		}
		return "/jsp/cart.jsp";
	}

}
