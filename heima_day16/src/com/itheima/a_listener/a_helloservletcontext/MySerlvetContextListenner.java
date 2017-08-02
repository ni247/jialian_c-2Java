package com.itheima.a_listener.a_helloservletcontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySerlvetContextListenner implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	//创建操作
		System.out.println("servletContext创建了");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext销毁了");
	}

}
