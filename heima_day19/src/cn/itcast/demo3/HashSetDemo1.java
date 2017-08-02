package cn.itcast.demo3;

import java.util.HashSet;

/*
 *  哈希表的存储过程
 *  
 *  存储时: .add("abc")
 *  先调用对象的哈希值  hashCode()   96354
 *  集合会在容器中搜索有没有和96354一样的哈希值
 *  没有插入.
 *  有则集合会让后来的对象new String("abc")调用方法equals(已由的对象)
 *  两个对象,哈希值一样,equals方法返回true. 判断元素重复
 *  
 *  哈希表,存储对象依据.对象的哈希值.和equals
 */
public class HashSetDemo1 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new String("bbc"));
		set.add(new String("bbc"));
		System.out.println(set.size());
		//		结果为2
	}
}
