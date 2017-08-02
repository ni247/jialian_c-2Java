package com.itheima.a_annatation.plus;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static boolean annotationPresent;
	private static Annotation annotation;
	private static Method method;

	@JdbcInfo(url = "jdbc:mysql:///day16")
	public static Connection getConnection()
			throws SQLException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		// 获取字节码文件
		Class c = JdbcUtils.class;
		// 获取getConnection方法
		Method method = c.getMethod("getConnection");
		// 判断该方法是否有该注解
		boolean annotationPresent = method.isAnnotationPresent(JdbcInfo.class);
		if (!annotationPresent)
			return null;
		JdbcInfo jdbcinfo = method.getAnnotation(JdbcInfo.class);

		// 获取注解的4个属性
		String driverClass = jdbcinfo.driverClass();
		String url = jdbcinfo.url();
		String user = jdbcinfo.user();
		String password = jdbcinfo.password();

		// 注册驱动
		Class.forName(driverClass);
		// 获取连接
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, SQLException {
		System.out.println(getConnection());
	}
}
