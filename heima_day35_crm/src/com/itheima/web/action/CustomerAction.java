package com.itheima.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itheima.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 客户的action
 * @author Administrator
 *
 */
public class CustomerAction extends ActionSupport {

	/**
	 * 保存客户
	 */
	private static final long serialVersionUID = 113695314694166436L;

	public String save() {
		System.out.println("web层,保存客户");
		// 使用工厂
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		// 思路:因为将ac放入唯一总域 servletContext中了.监听器中已经初始化
		WebApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(ServletActionContext.getServletContext());
		ICustomerService ic = (ICustomerService) ac.getBean("customerService");
		// 调用业务层
		ic.save();

		return NONE;
	}
}
