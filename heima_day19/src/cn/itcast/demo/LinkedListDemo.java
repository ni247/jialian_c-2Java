package cn.itcast.demo;

import java.util.LinkedList;

/*
 *  LinkedList 链表集合的特有功能
 *  
 *  主要讲子类的特有功能
 */
public class LinkedListDemo {
	public static LinkedList<String> list = new LinkedList<>();

	public static void main(String[] args) {
		//		function_1();
		//		function_2();
		function_3();
	}

	/*
	 *  E removeFirst() 移除并返回表开头 
	 *  E removeLast()  移除并返回表结尾
	 */
	public static void function_3() {
		list.clear();
		list.add("999");
		list.add("abc");
		list.add("bcd");
		list.add("1");
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list);
	}

	/*
	 *  E getLast() 获取结尾
	 *  E getFirst() 获取开头
	 */
	public static void function_2() {
		list.clear();
		list.add("999");
		list.add("abc");
		list.add("bcd");
		list.add("1");
		if (!list.isEmpty()) {
			System.out.println(list.getFirst());
			System.out.println(list.getLast());
		}
		//		System.out.println(((org.w3c.dom.Nodee<String>)list).item);
	}

	public static void function_1() {
		list.clear();
		list.addLast("999");
		list.add("abc");
		list.add("bcd");
		list.addFirst("1");
		System.out.println(list);
	}

	/*
	 *  addFirst(E)
	 *  addLast(E)
	 */
	public static void function() {
		list.clear();
		list.addLast("999");
		list.add("abc");
		list.add("bcd");
		list.addFirst("1");
		System.out.println(list);
	}
}
