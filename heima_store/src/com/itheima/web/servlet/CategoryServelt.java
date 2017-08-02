package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.constant.CCategoryConstant;
import com.itheima.constant.CCommonConstant;
import com.itheima.domain.Category;
import com.itheima.service.ICategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.JsonUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CategoryServelt
 */
public class CategoryServelt extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws Exception 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 查询最热商品和最新商品到request域中

		// TODO:查询所有分类返回list
		// 创建service
		ICategoryService s = (ICategoryService) BeanFactory.getBean("CategoryService");
		// 调用方法,返回list
		List<Category> list = s.findAll();
		// 放入request中
		req.setAttribute(CCategoryConstant.CACHE_CATEGORY_LIST, list);
		// 将返回值返回json格式
		String jsonStr = JsonUtil.list2json(list);
		resp.setContentType(CCommonConstant.RES_CONTENT_TYPE);
		resp.getWriter().print(jsonStr);
		return null;
	}

}
