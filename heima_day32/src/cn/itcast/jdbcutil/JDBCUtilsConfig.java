package cn.itcast.jdbcutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 *  编写jdbc的工具类,采取数据库的链接.
 *  采用读取配置文件的方式
 *  获取链接,执行一次足矣,使用static{}
 */
public class JDBCUtilsConfig {
	private static Connection con;
	private static String driveClass;
	private static String username;
	private static String password;
	private static String url;

	public static Connection getConnection() {
		return con;
	}

	static {
		try {
			readConfig();
			Class.forName(driveClass);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			throw new RuntimeException("配置文件读取失败");
		}
	}

	private static void readConfig() throws Exception {
		InputStream in = JDBCUtilsConfig.class.getClassLoader()
				.getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(in);
		driveClass = pro.getProperty("dirverClass");
		url = pro.getProperty("url");
		username = pro.getProperty("username");
		password = pro.getProperty("password");
	}
}
