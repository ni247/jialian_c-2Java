package cn.itcast.demo01;

public class RegexDemo1 {
	public static void main(String[] args) {
		//		splitDemo_2();
		replaceAllDemo();
	}

	/*
	 *  在这里使用" +"进行切割,可以实现忽略多个空格
	 */
	public static void splitDemo() {
		String str = "12  25  36  98";
		String[] newStrArr = str.split(" +");
		for (int i = 0; i < newStrArr.length; i++) {
			System.out.println(newStrArr[i]);
		}
	}

	/*
	 *  需要注意的是因为在正则表达式中,.匹配的是任意一个字符.
	 *  必须得转成\\.
	 */
	public static void splitDemo_2() {
		String str = "12.25.36.98";
		String[] newStrArr = str.split("\\.");
		for (int i = 0; i < newStrArr.length; i++) {
			System.out.println(newStrArr[i]);
		}
	}

	/*
	 * 需要注意的都是不改变本身,返回
	 * 一次匹配多个数字
	 */
	public static void replaceAllDemo() {
		String str = "hello123456world";
		str = str.replaceAll("[\\d]+", "######");
		System.out.println(str);
	}
}
