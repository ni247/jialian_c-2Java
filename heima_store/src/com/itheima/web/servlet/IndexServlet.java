package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CCategoryConstant;
import com.itheima.constant.CCommonConstant;
import com.itheima.constant.CProductConstant;
import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.ICategoryService;
import com.itheima.service.IProductService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.utils.BeanFactory;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 查询最热商品和最新商品到request域中
		IProductService ps = (IProductService) BeanFactory.getBean("ProductService");

		List<Product> newList = ps.findNew();

		List<Product> hotList = ps.findHot();
		// 将两个list放入quest域中
		req.setAttribute(CProductConstant.CHCHE_NEW_PRODUCT_LIST, newList);
		req.setAttribute(CProductConstant.CHCHE_HOT_PRODUCT_LIST, hotList);
		return CCommonConstant.DEFAULT_PAGE2;
	}
}
