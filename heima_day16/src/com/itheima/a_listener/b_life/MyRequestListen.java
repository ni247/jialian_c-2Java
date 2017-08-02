package com.itheima.a_listener.b_life;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListen implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("请求销毁了");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("请求过来了");
	}

}
