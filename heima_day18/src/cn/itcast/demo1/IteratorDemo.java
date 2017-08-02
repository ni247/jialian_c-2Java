package cn.itcast.demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Iterator :迭代器,获取集合中元素方式
 * boolean hasNext() 获取下一个元素,有true
 * object next() 去除集合的下一个元素
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc1");
		coll.add("a2");
		coll.add("a3");
		coll.add("a4");
		//迭代器,对集合ArrayList中的元素进行去除
		Iterator<String> it = coll.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
