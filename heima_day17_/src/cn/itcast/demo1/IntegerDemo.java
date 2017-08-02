package cn.itcast.demo1;

/*
 *  Integer类,封装基本数据类型int,提高大量方法
 */
public class IntegerDemo {
	public static void main(String[] args) {
		function_1();
	}

	/*
	 *  Integer类中静态方法 parseInt(String s)
	 */
	public static void function() {
		int i = Integer.parseInt("12");
		System.out.println(i);
	}

	/*
	 *  radix 基数,进制.
	 *  标识112是2进制的.
	 *  输出都是10进制的
	 */
	public static void function_1() {
		int i = Integer.parseInt("112", 10);
		System.out.println(i);
	}

	public static void function_3() {
		Integer in = new Integer("100");
		int i = in.intValue();
		System.out.println(i);
	}
}
