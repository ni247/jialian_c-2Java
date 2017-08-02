package com.itheima.demo1;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo {
	/**
	 * 测试
	 * @throws OgnlException 
	 */
	@Test
	public void run1() throws OgnlException {
		// 上下文对象
		OgnlContext context = new OgnlContext();
		// 获取到根对象
		Object root = context.getRoot();
		// 存储数据
		context.put("name", "美美");
		// 获取值
		Object value = Ognl.getValue("#name", context, root);
		System.out.println(value);
	}

	/**
	 * ognl调用方法
	 * @throws OgnlException 
	 */
	@Test
	public void run2() throws OgnlException {
		// 上下文对象
		OgnlContext context = new OgnlContext();
		// 获取到根对象
		Object root = context.getRoot();
		// 获取值
		Object value = Ognl.getValue("'haha'.length()", context, root);
		System.out.println(value);
	}
}
