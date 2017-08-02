package cn.itcast.demo;

import java.util.ArrayList;
import java.util.List;

/*
 * list接口特点:
 * 有序,索引,可以重复元素
 * 和set相反
 *   实现类:ArrayList
 */
public class ListDemo {
	public static void main(String[] args) {
		function();
		function_1();
		function_2();
	}

	/*
	 *  修改指定索引上的元素
	 *  E set(int index,E)
	 *  修改指定索引上的元素
	 *  返回被修改前的元素
	 *  索引最大值为size()-1
	 */
	public static void function_2() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);
		System.out.println(list.set(2, 3));
		System.out.println(list);
	}

	/*
	 * E remove(int index)
	 * 移除指定索引数据,返回删除的元素
	 */
	public static void function_1() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		String d = list.remove(0);
		System.out.println(d);
		System.out.println(list);
	}

	/*
	 *  add(int index,E)
	 *  将元素插到指定索引上
	 *  需要注意的是List导入包是util中的包.不是awt
	 *  需要注意的是最大的索引是size()
	 */
	public static void function() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list);
		list.add(3, "4");
		System.out.println(list);
	}
}
