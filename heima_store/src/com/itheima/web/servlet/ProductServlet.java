package com.itheima.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CProductConstant;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.utils.BeanFactory;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String getById(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String productId = req.getParameter("pid");
		IProductService ps = (IProductService) BeanFactory.getBean("ProductService");
		Product product = ps.getById(productId);
		req.setAttribute(CProductConstant.PRODUCT, product);
		return "/jsp/product_info.jsp";
	}

	public String findByPages(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 获取基本参数
		String cid = req.getParameter("cid");
		String currPage = req.getParameter("currPage");
		// 调用service方法.返回pageBean对象
		IProductService ps = (IProductService) BeanFactory.getBean("ProductService");
		PageBean<Product> data = ps.findByPages(cid, Integer.parseInt(currPage), CProductConstant.PAGE_SIZE);
		// 放入域中
		req.setAttribute(CProductConstant.PRODUCT_LIST, data);
		return "/jsp/product_list.jsp";
	}
}
