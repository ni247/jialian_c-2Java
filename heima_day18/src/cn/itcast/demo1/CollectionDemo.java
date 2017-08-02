package cn.itcast.demo1;

import java.util.ArrayList;
import java.util.Collection;

/*
 *  Collection接口中的方法
 *  是集合所有实现类必须拥有的方法
 *  使用Collection接口的实现类,演示
 *  
 */
public class CollectionDemo {
	public static void main(String[] args) {
		function();
		function_1();
		function_2();
		function_3();
	}

	/*
	 *  remove 删除第一个遇到的元素
	 */
	public static void function_3() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("a");
		coll.add("b");
		coll.add("a");
		boolean b = coll.remove("a");
		System.out.println(b);
		System.out.println(coll);
	}

	/*
	 *  Collection接口方法
	 *  toArray()集合中的元素,转成一个数组中的元素.集合转成数组
	 *  返回的是一个存储对象的数组,存储的是object
	 */
	public static void function_2() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("a");
		coll.add("b");
		coll.add("c");
		Object[] arr = coll.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	/*
	 *  java中三种长度表现形式
	 *  数组.length 属性 返回值 int 数组专用length属性.其他都是用方法
	 *  字符串.length() 方法,返回值int
	 *  集合.size()方法,返回值int
	 *  
	 */

	/*
	 *  Collection接口的方法
	 *  void clear() 清空集合中的所有元素
	 */
	public static void function() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("a");
		coll.add("b");
		coll.add("c");
		System.out.println(coll);
		coll.clear();
		System.out.println(coll);
	}

	/*
	 *  Collection接口方法
	 *  boolean contains(object)
	 *  判断对象是否存在于集合中,存在返回true
	 */

	public static void function_1() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("a");
		coll.add("b");
		coll.add("c");
		System.out.println(coll.contains("a"));
	}
}
