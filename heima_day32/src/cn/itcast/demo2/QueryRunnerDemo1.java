package cn.itcast.demo2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Sort;
import cn.itcast.jdbcutil.JDBCUtilsConfig;

/*
 *  queryRUnner数据查询操作
 *  调用queryRunner类方法query(connection con,String sql,resultsethandler r,object...params)
 *  resultsethandler r结果集的实现方式,传递resultsethandler接口实现类
 *  
 *  注意:query 返回值是泛型
 */
public class QueryRunnerDemo1 {
	static Connection conn;
	static QueryRunner qr;
	static {
		conn = JDBCUtilsConfig.getConnection();
		qr = new QueryRunner();
	}

	public static void main(String[] args) throws SQLException {
		mapListHandler();
	}

	/*
	 * 结果集第8中处理方法,mapListHandler
	 * 将结果集每一行存储到map集合,健:列名,值,数据
	 * map集合过多,存储到List集合  
	 */
	static void mapListHandler() throws SQLException {
		String sql = "select * from sort";
		List<Map<String, Object>> list = qr.query(conn, sql,
				new MapListHandler());
		for (Map<String, Object> map : list) {
			for (String key : map.keySet()) {
				System.out.print(key + map.get(key));
			}
			System.out.println();
		}
	}

	/*
	 * 结果集第七种处理方法 MapHandler
	 * 将结果集第一行数据,封装到Map集合中
	 * Map<键,值> 键就是列名.
	 */
	static void mapHandler() throws SQLException {
		String sql = "select * from sort";
		//调用方法query,传递结果集实现类MapHandler
		Map<String, Object> map = qr.query(conn, sql, new MapHandler());
		//便利map集合
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}

	/*
	 *  结果集第6中处理方法,ScalarHandler
	 *  对于查询后只有一个结构
	 *  注意数据类型是Long
	 */
	static void scalarHandler() throws SQLException {
		String sql = "select count(*) from sort";
		long count = qr.query(conn, sql, new ScalarHandler<Long>());
		System.out.println(count);
	}

	/*
	 * 结果集第五种处理方法,columnListHandler
	 * 结果集,指定列的数据,存储到List集合
	 */
	static void columnListHandler() throws SQLException {
		String sql = "select * from sort";
		//实现类构造方法中,使用字符串的列名
		List<Object> list = qr.query(conn, sql, new ColumnListHandler<Object>(
				"sname"));
		for (Object obj : list)
			System.out.println(obj);
	}

	/*
	 * 结果集的第四种处理方法,beanListHandler
	 * 将结果集的数据,封装成List javabean对象
	 * 注意:被封装成数据javabean对象,sort类必须有空参构造
	 */
	static void beanListHandler() throws SQLException {
		String sql = "select * from sort";
		List<Sort> s = qr.query(conn, sql,
				new BeanListHandler<Sort>(Sort.class));
		for (Sort sort : s)
			System.out.println(sort);
		DbUtils.closeQuietly(conn);
	}

	/*
	 * 结果集的第三种处理方法,beanHandler
	 * 将结果集的第一行数据,封装成javabean对象
	 * 注意:被封装成数据javabean对象,sort类必须有空参构造
	 */
	static void beanHandler() throws SQLException {
		String sql = "select * from sort";
		Sort s = qr.query(conn, sql, new BeanHandler<Sort>(Sort.class));
		System.out.println(s);
		DbUtils.closeQuietly(conn);
	}

	/*
	 * 结果集第二种处理方法,ArrayListHandler
	 * 将结果集的每一行,封装到对象数组中.出现很多对象数组
	 * 对象数组存储到List集合中
	 */
	static void arrayListHandler() throws SQLException {
		String sql = "select * from sort";
		List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
		System.out.println(list);
		System.out.println(list.size());
		for (Object[] objs : list) {
			for (Object obj : objs) {
				System.out.println(obj);
			}
		}

	}

	/*
	 * 结果集第一种处理方法,ArrayHandler
	 */
	static void arrayHandler() throws SQLException {
		String sql = "select * from sort";
		//返回对象数组
		Object[] result = qr.query(conn, sql, new ArrayHandler());
		for (Object obj : result) {
			System.out.print(obj);
			System.out.println();
		}
	}
}
