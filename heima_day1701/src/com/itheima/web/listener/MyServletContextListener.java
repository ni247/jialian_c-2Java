package com.itheima.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletcontext域创建了");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
