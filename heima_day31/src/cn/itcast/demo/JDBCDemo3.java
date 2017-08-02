package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * statement接口实现类
 *  有一个子接口preparedStatement(sql预编译存储,多次高效的执行sql)
 *  PreparedStatement prepareStatement(String sql)
 */
public class JDBCDemo3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String userName = "root";
		String passWord = "123";
		Connection con = DriverManager.getConnection(url, userName, passWord);
		//通过写?占位符
		String sql = "SElect * from users where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		//返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
		String username = new Scanner(System.in).nextLine();
		String pasword = new Scanner(System.in).nextLine();
		ps.setObject(1, username);
		ps.setObject(2, pasword);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs);
		//5.处理结果集
		//ResultSet接口方法boolean.next() 返回true,有结果集.如果false则没有
		while (rs.next()) {
			//获取每列的数据.使用的是resultSet接口的方法,getXXX
			/*	System.out.println("我是编号方式" + rs.getInt(1) + "====="
						+ rs.getString(2) + "=====" + rs.getDouble(3)
						+ "==========" + rs.getString(4));
				System.out.println("--------------------------");*/
			//推荐使用这种方法.可以写getString
			System.out.println(rs.getString("username") + "====="
					+ rs.getString("password") + "=====");

			System.out.println("--------------------------");
		}

		rs.close();
		ps.close();
		con.close();
	}
}
