package cn.itcast.demo2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
 *  HashTable 线程安全的集合,运行速度慢
 *  HashMap 线程不安全,运行速度快
 *  
 *  需要注意的是HashMap可以存储null键值
 *  HashTable不允许
 */
public class HashTableDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		System.out.println(map);
		map = new Hashtable<String, String>();
		map.put(null, null);
		System.out.println(map);
	}
}
