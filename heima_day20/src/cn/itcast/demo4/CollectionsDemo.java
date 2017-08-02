package cn.itcast.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		//		function();
		//		function_1();
		function_2();
	}

	/*
	 * shuffle对集合进行随机排列
	 */
	static void function_2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	/*
	 *  Collections.binarySearch静态方法
	 *  对List集合进行二分搜索,方法搜索,传递List集合.传递被查找的元素
	 *  必须是有序集合
	 */
	static void function_1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(Collections.binarySearch(list, 3));

	}

	/*
	 * Collections.sort静态方法
	 * 对List集合,进行升序排序(因为set无索引.)
	 */
	static void function() {
		List<String> list = new ArrayList<String>();
		//根据ACI码排序
		list.add("ewrew");
		list.add("ewcew");
		list.add("bv");
		list.add("wer");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
