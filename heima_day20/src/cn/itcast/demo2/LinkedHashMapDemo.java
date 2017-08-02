package cn.itcast.demo2;

import java.util.LinkedHashMap;

/*
 *  保证顺序的HashMap
 */
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		System.out.println(map);
	}
}
