package cn.itcast.demo03;

/*
 *  也可以通过实例名调用出静态数据.和c#不同
 *  被静态修饰的成员,可以被类名直接调用,也可以被实例调用.像调用普通成员一样
 *  所有该类对象都共享一个静态成员变量 
 *  
 *  共享变量
 *  
 *  方法区or数据共享区(静态区)
 *  先放main方法到静态区
 *  类,进入到方法区后,先加载自己的静态成员.赋默认值
 *  程序开始执行,运行main.jvm到静态区将main方法复制一份压栈运行(都是从数据共享区中复制出来的)
 *  下面代码.从jvm静态区,找到属于Person类的静态属性className,
 *  在内存中,静态优先于非静态存在
 *  
 *  
 *  静态是属于自己的类.所以java 类名,而不是java 类名.class
 */
public class Test {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		p1.name = "554";
		p2.name = "555";
		Person.className = "444";
//		p1.className = "555";
//		p2.className = "666";
		System.out.println(Person.className);
	}
}
