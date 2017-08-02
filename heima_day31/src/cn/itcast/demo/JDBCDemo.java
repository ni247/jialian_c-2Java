package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc操作数据库的步骤
 * 1.注册驱动
 * 告知jvm使用的是哪一个数据库的驱动
 * 2.获得连接
 * 使用jdbc中类,完成对mysql数据库的链接
 * 3.获取语句执行平台
 * 通过链接对象获取对sql语句的执行者对象
 * 4.执行sql语句
 * 使用执行者对象,向数据库执行sql语句
 * 获取到数据库的执行后的结果
 * 5.处理结果
 * 
 * 6.释放资源
 */
public class JDBCDemo {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//1.注册驱动.最好使用反射技术.将驱动类加入到内容
		//使用java.sql.driverManger类静态方法registerDriver(Drive drive)
		//	DriverManager.registerDriver(new Driver());
		//驱动类源代码,注册两次了驱动
		Class.forName("com.mysql.jdbc.Driver");

		//获得数据库连接
		//DriverManager类中的静态方法
		//static Connection(String url,String user,String password)
		//返回的是Connction实现类,在mysql驱动程序中.
		//url:数据库地址 jdbc:mysql://连接的主机ip:端口号(一般3306)//数据库名
		String url = "jdbc:mysql://localhost:3306/mybase";
		String userName = "root";
		String passWord = "123";
		//		  con = dr .getConnection(url, userName, passWord);
		Connection con = DriverManager.getConnection(url, userName, passWord);
		System.out.println(con);

		//3.获得语句执行平台,通过数据库连接对象,获取到sql语句的执行者对象
		//con对象调用 StateMent createStatement() 获取Statement对象,将数据语句发送到数据库
		//返回值是Statement接口的实现类对象,在mysql驱动承租
		Statement stat = con.createStatement();
		//执行sql语句
		//通过执行者对象调用方法,获取结果
		//int executeUpdate(String sql) 执行insert,delete,update
		//返回值int,操作成功数据表多少行
		int row = stat
				.executeUpdate("insert into sort(sname,sprice,sdesc) values('汽车用品',500000,'疯狂涨价')");
		System.out.println(row);
		//释放资源
		stat.close();
		con.close();
	}
}
