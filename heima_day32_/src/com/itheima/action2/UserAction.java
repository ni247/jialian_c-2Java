package com.itheima.action2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动态方法访问方式
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {
	public String save() {
		System.out.println("保存了用户");
		return NONE;
	}

	public String delete() {
		System.out.println("删除用户");
		return NONE;
	}
}
