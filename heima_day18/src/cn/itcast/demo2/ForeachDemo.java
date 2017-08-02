package cn.itcast.demo2;

import java.util.ArrayList;

import cn.itcast.demo1.Person;

public class ForeachDemo {
	public static void main(String[] args) {
		function();
		function_2();
	}
	
	public static void function_2(){
		ArrayList<Person> arr=new ArrayList<Person>();
		arr.add(new Person(17,"名字"));
		for (Person person : arr) {
			System.out.println(person);
		}
	}

	/*
	 * 可以使用对象的方法
	 */
	public static void function_1() {
		String[] arr = { "2" };
		for (String i : arr)
			System.out.println(i.length());
	}

	/*
	 *  格式: for(数据类型 变量名:目标集合)
	 *  需要注意的是不会改变值,虽然不会报错
	 *  优点:代码少,方便遍历
	 *  缺点:不能改变数据.没有索引.不能操作数据
	 */
	public static void function() {
		int[] arr = { 3, 5, 5, 1, 23, 11 };
		for (int i : arr)
			System.out.println(++i);
		for (int i : arr)
			System.out.println(i);
	}
}
