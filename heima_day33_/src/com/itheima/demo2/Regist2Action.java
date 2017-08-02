package com.itheima.demo2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动,2.封装到javabean
 * @author Administrator
 *
 */
public class Regist2Action extends ActionSupport {
	public User getUser() {
		System.out.println("getUser");
		return user;
	}

	public void setUser(User user) {
		System.out.println("setUser");
		this.user = user;
	}

	// 注意:需要提供get和set方法
	private User user = new User();

	@Override
	public String execute() throws Exception {
		// 需要注意的是,post可以直接转换,get请求需要手动new String
		System.out.println(user);
		return NONE;
	}
}
