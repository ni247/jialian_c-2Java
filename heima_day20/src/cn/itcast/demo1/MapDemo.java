package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Map;

/*
 * Map<K,V>
 * Map接口中的常用方法
 *   使用Map接口的实现类HashMap
 *   HashMap(无许)
 */
public class MapDemo {
	static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {
		function_2();
	}

	/*
	 *  移除集合中的键值对
	 *  V remove(K)
	 */
	static void function_2() {
		map.clear();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.remove("b"));
		System.out.println(map);
		System.out.println(map.size());
	}

	/*
	 *  通过键对象,获取值对象
	 *  V get(K)
	 *  没有获取到则返回null
	 */
	static void function_1() {
		map.clear();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		System.out.println(map);
		System.out.println(map.get("d"));
	}

	/*
	 *  将键值对存储到集合中
	 *  V put(K,V) K键,V值
	 *  如果有重复的键.则覆盖值
	 *  方法的返回值一般情况下返回null
	 *  需要注意,当你存储重复键的时候,返回被覆盖之前的值 
	 */
	public static void function() {
		map.clear();
		System.out.println(map.put("a", 1));
		map.put("b", 2);
		map.put("c", 3);
		System.out.println(map.put("c", 5));
		System.out.println(map);
	}
}
