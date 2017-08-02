package com.itheima.action;

public class HelloAction {

	/**
	 * Action类中的方法的签名是有要求.必须这么做
	 * public String
	 * 方法名称是任意,但是不能有参数列表
	 * 返回值是完成页面的跳转:
	 * 	1.return "要转发的页面";
	 * 	2.
	 */
	public String sayHello() {
		System.out.println("Hello struct2");
		return "ok";
	}

	public String execute() {
		System.out.println("method默认值execute");
		return null;
	}
}
