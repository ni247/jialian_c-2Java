package com.itheima.demo2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters.SecurityProviderConverter;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 演示值栈对象的目录结构
 * @author Administrator
 *
 */
public class ValueStackAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8246753468819749516L;

	@Override
	public String execute() throws Exception {
		// 使用获取值栈对象
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");

		// 获取值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		System.out.println(vs);
		// push(obj) 都会压入栈顶
		vs.push("小凤");
		// set(key,value) 压入栈顶map map新建
		vs.set("msg", "美美");
		// 取上面的map,往里面存
		vs.set("ss", "meim");
		return SUCCESS;
	}

	/**
	 * 演示从值栈中取值
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		ValueStack valueStack = ActionContext.getContext().getValueStack();

		/*
		 * valueStack.push("小凤"); // set(key,value) 压入栈顶map map新建
		 * valueStack.set("msg", "美美"); // 取上面的map,往里面存 valueStack.set("ss",
		 * "meim");
		 * 
		 * // 压入对象 valueStack.push(new User("小苍", "123")); valueStack.set("ss",
		 * "meim");
		 */

		List<User> list = new ArrayList<>();
		list.add(new User("熊大", "123"));
		list.add(new User("熊二", "123"));
		list.add(new User("熊散", "123"));
		valueStack.set("list", list);

		ServletActionContext.getRequest().setAttribute("msg", "fdf");

		return SUCCESS;
	}
}
