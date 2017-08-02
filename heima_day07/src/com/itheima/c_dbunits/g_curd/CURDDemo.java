package com.itheima.c_dbunits.g_curd;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.itheima.utils.DatasSourceUtils;

public class CURDDemo {
	@Test
	public void insert() throws Exception {
		// 1.创建queryrunner类
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		// 2.编写sql
		String sql = "insert into category values(?,?)";
		// 3.执行
		qr.update(sql, "c201", "厨房电器");

	}
}
