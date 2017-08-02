package com.itheima.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.service.ICustomerService;
import com.itheima.service.Impl.CustromerServiceImpl;
import com.itheima.utils.BeanFactory;

/**
 * Servlet implementation class SaveCustomer
 */
public class Customer extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map = request.getParameterMap();
		// 封装数据,使用beanutils工具,导入jar包
		com.itheima.domain.Customer c = new com.itheima.domain.Customer();
		try {
			BeanUtils.populate(c, map);
			// 调用业务层
			ICustomerService ic = (ICustomerService) BeanFactory.getBean("CustromerService");
			ic.saveOrUpdate(c);
			request.setAttribute("msg", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "失败");
		}
		return "/msg.jsp";
	}

	public String getListUI(HttpServletRequest request, HttpServletResponse response) {
		String queryValue = request.getParameter("nameValue");
		String queryName = "cust_name";
		List<com.itheima.domain.Customer> list = null;
		try {
			ICustomerService ic = (ICustomerService) BeanFactory.getBean("CustromerService");
			list = ic.getList(queryName, queryValue);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/customer/list.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("custId");
		boolean r;
		try {
			ICustomerService ic = (ICustomerService) BeanFactory.getBean("CustromerService");
			ic.delete(id);
			request.setAttribute("msg", "成功");
		} catch (Exception e) {
			request.setAttribute("msg", "失败");
			e.printStackTrace();
		}
		return "/msg.jsp";
	}

	public String editUI(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("custId");
		boolean r;
		try {
			ICustomerService ic = (ICustomerService) BeanFactory.getBean("CustromerService");
			com.itheima.domain.Customer c = ic.getById(id);
			request.setAttribute("customer", c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/customer/edit.jsp";
	}
}
