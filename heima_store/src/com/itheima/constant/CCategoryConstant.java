package com.itheima.constant;

/**
 * 分类表常量
 * @author Administrator
 *
 */
public interface CCategoryConstant {
	int HOT = 1; // 热门
	int NOT_HOT = 0;// 非热门
	int SOLD_OUT = 1;// 下架
	int NOT_SOLD_OUT = 1;// 未下架
	String CACHE_CATEGORY_LIST = "category_list"; // 所有类别缓存名
}
