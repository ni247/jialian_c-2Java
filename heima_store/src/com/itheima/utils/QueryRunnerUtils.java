package com.itheima.utils;

import org.apache.commons.dbutils.QueryRunner;

public class QueryRunnerUtils {
	public final static QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
}
