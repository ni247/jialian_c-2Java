package cn.itcast.demo01;

public class TestToString {
	public static void main(String[] args) {
		/*
		 * 调用Person类方法toString() 输出语句中,写的是一个对象,默认调用对象的toString()方法
		 */
		Person p = new Person("张三", 20);
		System.out.println(p);
	}
}
