package com.itheima.action;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块控制器
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理登录功能
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String login() throws IllegalAccessException, InvocationTargetException {
		System.out.println("正常输出了");
		// struct2获取request方式
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = new User();
		BeanUtils.populate(user, request.getParameterMap());
		User user2 = new UserService().login(user);
		System.out.println(user2 != null ? "成功了" : "失败了");
		return user2 != null ? SUCCESS : LOGIN;
	}
}
