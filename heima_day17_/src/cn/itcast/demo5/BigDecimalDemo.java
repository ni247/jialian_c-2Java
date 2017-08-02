package cn.itcast.demo5;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		/*
		 * 算钱专用类
		 */
		//		System.out.println(0.09 + 0.01);
		function_1();
	}

	/*
	 * BigDecimal实现除法运算
	 * divide(BigDecimal divisor,int scale,int roundingMode)
	 * int scale:保留几位小数
	 * int roundingMode:保留模式
	 * static int ROUND_UP 向上+1
	 * static int ROUND_DOWN 直接舍去
	 * static int ROUND_HALF_UP
	 */
	public static void function_1() {
		BigDecimal b1 = new BigDecimal("1.901");
		BigDecimal b2 = new BigDecimal("101");
		System.out.println(b1.divide(b2,3,BigDecimal.ROUND_HALF_UP));
	}

	/*
	 *  BigDecimal实现三则运算
	 *  +-* add subtract multiply
	 *  注意:需要使用字符串构造器
	 */
	public static void function() {
		BigDecimal b1 = new BigDecimal("0.09");
		BigDecimal b2 = new BigDecimal("0.01");
		BigDecimal b3 = b1.add(b2);
		System.out.println(b3);
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
	}
}
