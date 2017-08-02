package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Sort;
import cn.itcast.jdbcutil.JDBCUtils;

/*
 *  jdbc读取数据表sort,每行数据封住到sort类的对象中.
 *  很多sort类对象,存储到List集合中
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("select * from sort");
		ResultSet rs = pst.executeQuery();
		//创建集合对象
		List<Sort> list = new ArrayList<Sort>();
		Sort s;
		while (rs.next()) {
			//获取到的每列数据,封装到sort对象中
			s = new Sort(rs.getInt("sid"), rs.getString("sname"),
					rs.getDouble("sprice"), rs.getString("sdesc"));
			list.add(s);
		}
		for (Sort ss : list)
			System.out.println(ss);
		JDBCUtils.close(con, pst, rs);
	}
}
