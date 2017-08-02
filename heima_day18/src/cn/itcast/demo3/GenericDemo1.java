package cn.itcast.demo3;

import java.util.ArrayList;

/*
 *  带有泛型的类
 *   ArrayList<E>
 *   E:element,元素
 *   
 *   需要注意的是T也是一样的含义,K,V同样,只是用在不同的内容里
 *   T-type  类型
 *   E-element 元素-集合中
 */
public class GenericDemo1 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(66);
		Integer[] b = {};
		b = arr.toArray(b);
		for (Integer d : b)
			System.out.println(d);
		System.out.println("运行结束了吗");
	}
}
