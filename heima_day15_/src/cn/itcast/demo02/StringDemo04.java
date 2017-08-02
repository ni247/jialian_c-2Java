package cn.itcast.demo02;

public class StringDemo04 {
	public static final String STR_DEMO = "abcdefg";

	public static void main(String[] args) {
		// function();
		// substringDemo();
		function_3();
		function_4();
		function_5();
		function_6();
		function_7();
		function_8();
		function_9();
		functin_10();
	}

	/*
	 * boolean equals(Object obj) 方法传递字符串,判断字符串中的字符串是否完全相同,如果完全相同,返回true
	 * 
	 * boolean equalsIgnoreCase(String s) 传递字符串,判断字符串中的字符是否相同,忽略大小写
	 */
	public static void functin_10() {
		System.out.println(STR_DEMO.equalsIgnoreCase("ABCDEFG"));
	}

	/*
	 * char[] toCharArray() 将字符串转成字符数组 功能和构造方法相反
	 */
	public static void function_9() {
		char[] ch = STR_DEMO.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i]);
		}
	}

	/*
	 * 使用length() 方法获取字符串的长度
	 */
	public static void function() {
		System.out.println(STR_DEMO.length());
	}

	/*
	 * 需要注意的是substring中的第二个s也是小写的 String substring(int beginIndex,int endIndex)
	 * String substring(int beginIndex) 不修改原字符串,返回一个新的字符串
	 */
	public static void substringDemo() {
		System.out.println(STR_DEMO.substring(2, 4));
		System.out.println(STR_DEMO.substring(3));
	}

	/*
	 * boolean startsWith(String prefix) 判断一个字符串是不是另一个字符串的前缀开头 boolean
	 * startsWith(String prefix,int tooffset)
	 */
	public static void function_3() {
		System.out.println(STR_DEMO.startsWith("ab", 2));
	}

	public static void function_4() {
		System.out.println(STR_DEMO.endsWith("fg"));
	}

	public static void function_5() {
		System.out.println(STR_DEMO.contains("ab"));
	}

	/*
	 * int indexof(char ch) 查找一个字符,在字符串中第一次出现的索引 被查找的字符不存在,返回-1
	 */
	public static void function_6() {
		System.out.println(STR_DEMO.indexOf('c'));
	}

	/*
	 * int lastIndexof(char ch ) 查找一个字符,在字符串中最后一次出现的索引.被查找的字符不存在,返回-1
	 */
	public static void function_7() {
		System.out.println(STR_DEMO.lastIndexOf('c'));
	}

	/*
	 * byte[] getBytes() 将字符串转成字节数组 此功能和String构造方法相反 byte数组相关的功能,查询编码表
	 */
	public static void function_8() {
		byte[] bytes = STR_DEMO.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(bytes[i]);
		}
	}
}
