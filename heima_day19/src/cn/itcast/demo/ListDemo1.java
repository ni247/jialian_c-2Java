package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *  并发修改异常
 *  就是在遍历的时候,修改了集合的长度 
 *  因为指针只会往下走
 *  
 *  ArrayList 增删慢,查找快,因为增删需要新建一个数组,复制数据
 *  LinkedList 增删快,查找慢.
 *  两个类都是线程不安全的
 */
public class ListDemo1 {
	public static void main(String[] args) {
		function();
	}

	public static void function() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		//注意冒号
		//需要注意,因为字符串是引用变量
		//所以,需要用equals判断是否相等
		/*	for (String s : list) {
				if (s.equals("2"))
					list.add("4");
				System.out.println(list);
			}*/

		//需要注意.在遍历中不能修改长度.add remove禁止.可以set修改元素内容
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if (s.equals("2"))
				list.set(2, "44");
			System.out.println(list);
		}
	}
}
