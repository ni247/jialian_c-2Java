package com.itheima.servlet;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.service.ILinkmanService;
import com.itheima.utils.BeanFactory;

/**
 * Servlet implementation class Linkman
 */
public class Linkman extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 添加联系人UI
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String addLinkmanUI(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 调用service,获取联系人
		ILinkmanService is = (ILinkmanService) BeanFactory.getBean("LinkmanService");
		List<com.itheima.domain.Customer> list = is.addLinkmanUI();
		// 放入request域中.
		request.setAttribute("list", list);
		return "/jsp/linkman/add.jsp";
	}

	/**
	 * 添加联系人
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String addLinkman(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 调用beanutils,包装参数linkman
		com.itheima.domain.Linkman link = new com.itheima.domain.Linkman();
		BeanUtils.populate(link, request.getParameterMap());
		// 获取参数 cust id
		String cust_id = request.getParameter("cust_id");
		// 调用service,返回结果
		ILinkmanService is = (ILinkmanService) BeanFactory.getBean("LinkmanService");
		boolean r = is.addLinkman(link, cust_id);
		// 放入request域中.
		String msg = r ? "成功" : "失败";
		request.setAttribute("msg", msg);
		return "/msg.jsp";
	}

	/**
	 * 获取联系人列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String getLinkListUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String value = request.getParameter("lkmName");
		String key = "lkm_name";

		// 创建离线查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(com.itheima.domain.Linkman.class);
		if (value != null && !value.isEmpty()) {
			// 添加查询条件
			criteria.add(Restrictions.like(key, "%" + value + "%"));
		}
		// 查询
		ILinkmanService is = (ILinkmanService) BeanFactory.getBean("LinkmanService");
		List<com.itheima.domain.Linkman> list = is.getList(criteria);
		request.setAttribute("list", list);
		return "/jsp/linkman/list.jsp";
	}

}
