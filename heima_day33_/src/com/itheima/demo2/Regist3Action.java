package com.itheima.demo2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 模型驱动方式
 * 	1.实现ModelDriven接口
 *  2.必须手动实例化对象(需要自己new)
 * @author Administrator
 *
 */
public class Regist3Action extends ActionSupport implements ModelDriven<User> {

	@Override
	public String execute() throws Exception {
		// 需要注意的是,post可以直接转换,get请求需要手动new String
		System.out.println(user);
		return NONE;
	}

	private User user = new User();

	@Override
	// 获取模型对象
	public User getModel() {
		return user;
	}
}
