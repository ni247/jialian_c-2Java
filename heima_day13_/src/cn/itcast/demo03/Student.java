package cn.itcast.demo03;

/*
 * 在静态方法中不能调用非静态成员变量
 * 在实例方法中可以调用静态成员(成员变量,成员函数)
 * 
 * 为什么静态不能调用非静态
 * 原因是声明周期
 * 静态优先于非静态存在于内存中.
 * 
 * 静态 前人,先人  非静态 后人
 * 在静态当中不允许使用this,super同c#
 * 
 * 
 * 定义事物的时候,多个事物是否有共性的数据
 * 将共性的事物定义为静态变量
 */
public class Student {
	// private String name;
	// private int age;

	public static void show() {
		// System.out.println(age + name);
	}

	public void set() {
		show();
	}
}
