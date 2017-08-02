package cn.itcast.demo1;

public class IntegerDemo1 {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * Integer类的3个静态方法
	 * 做进制的转换
	 * 10进制转换为2进制 toBinaryString(int va)
	 * 10进制转换为8进制 toOctalString(int va)
	 * 10进制转换为16进制 toHexString(int)
	 * 返回值都是String
	 * 
	 * 其实就是toString的另一种写法
	 */
	public static void function_1(){
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toString(99, 2));
	}

	/*
	 *  Integer类的静态成员变量
	 *  max_value
	 *  min_value
	 */
	public static void function() {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
