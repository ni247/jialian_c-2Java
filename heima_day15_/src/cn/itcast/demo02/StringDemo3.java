package cn.itcast.demo02;

public class StringDemo3 {
	public static void main(String[] args) {
		// function();
		function_1();
	}

	/*
	 * String(char[] value) 传递字符数组 将字符数组,转成字符串.字符数组的参数,不查询编码表
	 * 
	 * String(char[] value,int offset,int count) 将字符串的一部分转成字符串 offset 数组开始索引
	 * count 个数
	 */
	public static void function_1() {
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
		System.out.println(new String(ch));
		System.out.println(new String(ch, 2, 2));
	}

	/*
	 * 构造方法 String(byte[] bytes) 传递字节数组 通过使用平台的默认字符集解码指定的byte数组.构造一个新的String
	 * 平台:机器操作系统 默认字符集:操作系统中的默认编码表,默认编码表gbk 将字节数组中的每个字节,查询了编码表,得到的结果
	 * 字节是负数,汉字的字节编码是负数,默认编码表.一个汉字采用2个字节标识
	 */
	public static void function() {
		byte[] bytes = { 97, 98, 99, 100 };
		String s = new String(bytes);
		System.out.println(s);

		byte[] bytes1 = { 65, 66, 67, 68, 69 };
		// 调用String构造方法,传递数组,传递2个int值

		/*
		 * String(byte[] bytes,int offset,int length) offset 第一个索引,length是长度
		 */

		String s1 = new String(bytes1, 3, 1);
		System.out.println(s1);

	}
}
