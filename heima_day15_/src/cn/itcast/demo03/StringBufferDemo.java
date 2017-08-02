package cn.itcast.demo03;

/*
 * 
 * StringBuffer 和StringBuilder差不多
 * StringBuffer 线程安全      速度慢
 * StringBuilder 线程不安全.速度快
 * 在单线程中操作推荐使用StringBuilder
 */
public class StringBufferDemo {
	public static void main(String[] args) {
		//		function();
		//		function_1();
		//		function_2();
		//		function_3();
		//		function_4();
		function_5();
	}

	/*
	 * toString() 继承Objcet,重写toString()方法.返回值时一个字符串
	 */
	public static void function_5() {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdsfaf");
		System.out.println(sb);
	}

	/*
	 *  reverse() 将缓冲区的字符反转
	 *  
	 */
	public static void function_4() {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg").reverse();
		System.out.println(sb);
	}

	/*
	 * 
	 * replace(int start,int end,String str)
	 * 将指定的索引范围内的所有字符,替换成新的字符串
	 */
	public static void function_3() {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg");
		sb.replace(1, 4, "Q");
		System.out.println(sb);
	}

	/*
	 *  insert (int index,任意类型)
	 *  将任意类型数据,插入到缓冲区的指定索引上
	 */
	public static void function_2() {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdeff");
		//放在3索引的前面
		sb.insert(10, 3.95);
		System.out.println(sb);

	}

	/*
	 *  StringBuffer类方法
	 *  delete(int start,int end) 删除缓冲区中字符
	 *  注意,java中参数是两个索引的,第一个开始索引包含,第二个结束索引都不包含
	 *  开始索引包含,结尾索引不包含
	 */
	public static void function_1() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcder").delete(0, buffer.length());
		System.out.println(buffer);

	}

	/*
	 *  StringBuffer类方法
	 *   append方法,将任意类型的数据,添加缓冲区
	 *   本身和返回值相同-可以调用链调用
	 */
	public static void function() {
		StringBuffer sb = new StringBuffer();
		StringBuffer ssb = sb.append("asdfgh");
		System.out.println(sb.toString());
		System.out.println(ssb.toString());
	}
}
