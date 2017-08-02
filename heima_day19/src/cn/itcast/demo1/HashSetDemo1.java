package cn.itcast.demo1;

import java.util.HashSet;

import cn.itcast.demo3.Person;

/*
 *  HashSet集合自身特点:
 *    底层数据结构,叫做哈希表
 *    存储,取出都比较快.
 *    线程不安全(运行速度快)
 *    
 *  哈希表(链表数组结合体)  
 *  初始容量,数组长度默认16
 *  加载因子是0.75
 *  也就是当数组中存元素的长度为16*0.75时,
 *  数组就扩容需要复制(耗费资源)
 *  也就是数据的在哈希
 *  
 */
public class HashSetDemo1 {
public static void main(String[] args) {
	HashSet<Person> setPerson=new HashSet<Person>();
	setPerson.add(new Person("a",20));
	setPerson.add(new Person("a",20));
	setPerson.add(new Person("c",22));
	setPerson.add(new Person("d",23));
	System.out.println(setPerson);
}
}
