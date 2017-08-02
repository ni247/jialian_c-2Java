package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc技术,查询数据表,获取结果集
 */
public class JDBCDemo1 {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String userName = "root";
		String passWord = "123";
		Connection con = DriverManager.getConnection(url, userName, passWord);
		//获取statement实现类对象
		Statement sta = con.createStatement();
		String sql = "Select * from sort";
		//返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
		ResultSet rs = sta.executeQuery(sql);
		System.out.println(rs);
		//5.处理结果集
		//ResultSet接口方法boolean.next() 返回true,有结果集.如果false则没有
		while (rs.next()) {
			//获取每列的数据.使用的是resultSet接口的方法,getXXX
			System.out.println("我是编号方式" + rs.getInt(1) + "====="
					+ rs.getString(2) + "=====" + rs.getDouble(3)
					+ "==========" + rs.getString(4));
			System.out.println("--------------------------");
			//推荐使用这种方法.可以写getString
			System.out.println(rs.getString("sid") + "====="
					+ rs.getString("sname") + "=====" + rs.getDouble("sprice")
					+ "==========" + rs.getString("sdesc"));

			System.out.println("--------------------------");
		}

		rs.close();
		sta.close();
		con.close();

	}
}
