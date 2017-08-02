package cn.itcast.demo1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set接口,特点,不重复元素,没有索引
 * 
 * Set接口的实现类:HashSet(哈希表)
 * 特点:无须集合,存储和去除的顺序不同,没有索引
 */
public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("cn");
		set.add("itcast");
		set.add("heima");
		set.add("java");
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println("========================");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
