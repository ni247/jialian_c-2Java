package com.itheima.c_dbuts.g_curd;

import java.util.Arrays;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;

import com.itheima.utils.DatasSourceUtils;

public class ResultHandlerDemo {
	@Test
	public void f1() throws Exception {
		QueryRunner qr = new QueryRunner(DatasSourceUtils.getDataSource());
		String sql = "select * from category";
		Object[] query = qr.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(query));
	}
}
