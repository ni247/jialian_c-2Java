package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

/*
 * 实现对数据表gjp_zhangwu 数据的增删改查
 * dbutils工具类完成.在类的成员创建出QueryRunner对象,指定数据源
 */
public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/*
	 * 查询所有账务数据
	 * 
	 */
	public List<ZhangWu> selectAll() {
		try {
			String sql = "select * from gjp_zhangwu";
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("查询所有账务失败");
		}

	}

	/*
	 * 条件查询账务信息
	 * 
	 */
	public List<ZhangWu> select(String start, String end) {
		try {
			String sql = "select * from gjp_zhangwu where createtime between ? and ?";
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class),
					start, end);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("查询条件账务失败");
		}

	}
}
