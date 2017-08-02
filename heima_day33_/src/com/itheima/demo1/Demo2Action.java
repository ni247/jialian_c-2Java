package com.itheima.demo1;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "原生servlet的request-req");
		request.getSession().setAttribute("msg", "原生 session-ses");
		request.getServletContext().setAttribute("msg", "原生context");
		return SUCCESS;
	}
}
