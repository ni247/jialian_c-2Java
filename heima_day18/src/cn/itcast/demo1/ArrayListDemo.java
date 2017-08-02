package cn.itcast.demo1;

import java.util.ArrayList;

/*
 *  集合体系:
 *    目标:集合本身是一个存储的容器
 *    必须使用集合存储独享
 *    遍历集合,取出对象
 *    集合自己的特性
 *    
 *  Collection接口是集合中的顶层接口  
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		ArrayList<Person> arrPer = new ArrayList<Person>();
		arrPer.add(new Person(17, "张三"));
		arrPer.add(new Person(19, "李四"));
		arrPer.add(new Person(18, "王五"));
		for (int i = 0; i < arrPer.size(); i++) {
			System.out.println(arrPer.get(i));
		}
	}
}
