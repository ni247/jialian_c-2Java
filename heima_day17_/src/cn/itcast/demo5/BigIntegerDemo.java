package cn.itcast.demo5;

import java.math.BigInteger;

/*
 *  超级大的整数运算
 *  超过long取值范围整数,封装成BigInteger类型的对象
 */
public class BigIntegerDemo {
	public static void main(String[] args) {
		function_1();
	}

	/*
	 * BigInteger对象的四则运算
	 * 都是调用方法计算,结果也都是BigInteger对象
	 * 加add 
	 * 减subtract
	 * 乘法multiply
	 * 除法 divied
	 */
	public static void function_1() {
		BigInteger b1 = new BigInteger("1111111111133312312312312");
		BigInteger b2 = new BigInteger("1111111111133312312312312");
		BigInteger b3 = b1.add(b2);
		System.out.println(b3);
	}

	/*
	 *  BigInteger类的构造方法
	 *  传递字符串,要求数字格式,没有长度限制
	 */
	public static void function() {
		BigInteger b = new BigInteger("1111111111133");
		BigInteger b1 = new BigInteger("1111111111133312312312312");
		System.out.println(b);
		System.out.println(b1);
	}
}
