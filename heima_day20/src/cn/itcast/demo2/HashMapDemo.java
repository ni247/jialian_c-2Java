package cn.itcast.demo2;

import java.util.HashMap;
import java.util.Map;

/*
 *  使用HashMap集合,存储自定义对象
 *  自定义对象,作为键出现,
 */
public class HashMapDemo {
	public static void main(String[] args) {
		function();
	}

	/*
	 * HashMap存储自定义对象Person,作为键出现
	 * 需要注意保证键的唯一性,重写HashCode和equals
	 */
	public static void function_1() {
		HashMap<Person, String> map = new HashMap<>();
		map.put(new Person("A", 20), "beijing");
		map.put(new Person("B", 21), "tianjin");
		map.put(new Person("C", 22), "shanghai");
	}

	/*
	 *  HashMap 存储自定义的对象Person,作为值出现
	 */
	public static void function() {
		HashMap<String, Person> map = new HashMap<String, Person>();
		map.put("beijing", new Person("A", 20));
		map.put("tianjin", new Person("B", 21));
		map.put("shanghai", new Person("C", 22));
		//增强for形式 keySet()
		for (String key : map.keySet()) {
			System.out.println(map.get(key) + "..." + key);
		}
		//增强for形式EntrySet() 返回Set<Map.Entry<String, Person>>
		for (Map.Entry<String, Person> entry : map.entrySet()) {
			System.out.println(entry.getValue() + "..." + entry.getKey());
		}
	}
}
