package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate框架的工具类
 * @author Administrator
 *
 */
public class HibernateUtils {
	// ctrl+shift+x 变成大写
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	// 静态代码块
	static {
		// 加载xml文件
		CONFIG = new Configuration().configure();
		// 创建config工厂
		FACTORY = CONFIG.buildSessionFactory();
	}

	public static Session getSession() {
		return FACTORY.openSession();
	}

	/**
	 * 从threadlocal中获取session对象
	 * @return
	 */
	public static Session getCurrentSession() {
		return FACTORY.getCurrentSession();
	}

	public static void main(String[] args) {
		getSession();
	}
}
