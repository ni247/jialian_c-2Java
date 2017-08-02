package cn.itcast.homework;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Work1 {
	public static void main(String[] args) {
		HashSet<String> list = new LinkedHashSet<String>();
		list.add("a");
		list.add("f");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("d");
		System.out.println(list);
	}
}
