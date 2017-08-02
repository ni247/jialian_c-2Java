package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *  Map集合获取方式
 *  entrySet方法,键值对映射关系获取
 *  实现步骤:
 *     1.调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
 *       Set<Entry<K,v>>
 *     2.迭代Set集合
 *     3.获取出的Set集合的元素,是映射关系的对象
 *     4.通过映射关系对象方法getKey,getValue获取键值对
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "abc");
		map.put(2, "bcd");
		map.put(3, "cde");
		/*迭代器方法
		1.调用map集合方法entrySet(),将集合中的映射关系对象,存储到Set集合*/
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		//2.迭代Set集合
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			System.out.println(entry.getKey() + "..." + entry.getValue());
		}

		System.out.println("=======================");
		//增强for
		for (Map.Entry<Integer, String> entry : set) {
			System.out.println(entry.getKey() + "..." + entry.getValue());
		}
	}
}
