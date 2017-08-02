package com.itheima.demo2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动,1.封装到action类中的属性
 * @author Administrator
 *
 */
public class Regist1Action extends ActionSupport {
	private String username;
	private String password;
	private Integer age;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String execute() throws Exception {
		// 需要注意的是,post可以直接转换,get请求需要手动new String
		System.out.println("usermae:" + username + "password" + password + "age" + age);
		return NONE;
	}
}
