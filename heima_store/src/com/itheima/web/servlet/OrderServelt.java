package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CCartConstant;
import com.itheima.constant.CCommonConstant;
import com.itheima.constant.COrderConstant;
import com.itheima.constant.CUserConstant;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.IOrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;

/**
 * Servlet implementation class OrderServelt
 */
public class OrderServelt extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**提交订单
	 * @throws Exception 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String commitOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 0 判断用户是否登录
		User user = (User) request.getSession().getAttribute(CUserConstant.USER_ATTR);
		// 0-0.未登录,则跳转到登录界面
		/*
		 * if (user == null) { request.setAttribute("msg", "未登录,请登录"); return
		 * CCommonConstant.LOGIN_PAGE; }
		 */
		// 1 登录状态下,封装数据
		Order order = new Order();
		order.setOid(UUIDUtils.getId());
		order.setOrdertime(new Date());
		Cart cart = (Cart) request.getSession().getAttribute(CCartConstant.CART_ATTR);
		order.setTotal(cart.getTotal());
		order.setUser(user);
		// 订单的所有项
		// 获取cart中的items,遍历items,组成成orderitem
		// 将orderitem中添加到list(items)中
		Collection<CartItem> items = cart.getItems();
		List<OrderItem> list = new LinkedList<>();
		for (CartItem cartItem : items) {
			list.add(convert(cartItem, order));
		}
		order.setList(list);
		order.setUser(user);

		// 调用service,数据库操作
		IOrderService ps = (IOrderService) BeanFactory.getBean("OrderService");
		ps.commitOrder(order);
		// 2将order放入request域中,请求转发
		request.setAttribute(COrderConstant.ORDER, order);
		// 清空购物车
		request.getSession().removeAttribute(CCartConstant.CART_ATTR);
		return "/jsp/order_info.jsp";
	}

	public OrderItem convert(CartItem cartI, Order order) {
		if (cartI == null || order == null)
			return null;
		OrderItem orderI = new OrderItem();
		orderI.setCount(cartI.getCount());
		orderI.setItemid(UUIDUtils.getId());
		orderI.setOrder(order);
		orderI.setProduct(cartI.getProduct());
		orderI.setSubtotal(cartI.getSubtotal());
		return orderI;
	}

	/**
	 * 我的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getPageOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取用户.
		User user = (User) request.getSession().getAttribute(CUserConstant.USER_ATTR);
		/*
		 * // 未登录,则跳转到登录界面 if (user == null) { request.setAttribute("msg",
		 * "未登录,请先登录"); return CCommonConstant.LOGIN_PAGE; }
		 */
		// 获取页数
		int currPage = Integer.parseInt(request.getParameter("currPage").toString());

		// 调用serviec方法.获取PageBean<Order>
		IOrderService os = (IOrderService) BeanFactory.getBean("OrderService");
		PageBean<Order> pageData = os.getPageOrder(user, currPage, CCommonConstant.PAGE_SIZE);
		// 放入域中.返回
		request.setAttribute(COrderConstant.ORDER_PAGE, pageData);
		return "/jsp/order_list.jsp";
	}

	public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * // 获取用户. User user = (User)
		 * request.getSession().getAttribute(CUserConstant.USER_ATTR); //
		 * 未登录,则跳转到登录界面 if (user == null) { request.setAttribute("msg",
		 * "未登录,请先登录"); return CCommonConstant.LOGIN_PAGE; }
		 */
		String oid = request.getParameter("oid");
		// 调用serviec方法.获取PageBean<Order>
		IOrderService os = (IOrderService) BeanFactory.getBean("OrderService");
		Order order = os.getById(oid);
		// 放入域中.返回
		request.setAttribute(COrderConstant.ORDER, order);
		return "/jsp/order_info.jsp";
	}

}
