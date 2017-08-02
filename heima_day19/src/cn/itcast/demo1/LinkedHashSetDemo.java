package cn.itcast.demo1;

import java.util.LinkedHashSet;

/*
 *  LinkedHashSet 基于链表的哈希表实现
 *  继承自HashSet
 *  
 *  LinkedHashSet 自身特性:具有顺序,存储和取出的顺序相同
 *  
 *  根据sum公司的规定
 *  如果equals方法结果相等.则hashCode返回相同
 *  hashCode相等.equals可能不同
 */
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		link.add(1);
		link.add(2);
		link.add(3);
		link.add(4);
		System.out.println(link);
	}
}
