package cn.incast.demo01;

/*
 * 定义了一个显视构造器后,默认的构造器就消失了
 * 如果没有,编译器会自动添加一个无参构造方法
 * 
 * 对象进入堆内存,对自己的成员变量赋初始值.
 * 对象调用自己的构造方法,构造方法压栈运行
 * 对象的内存地址传递给this关键字
 * 构造方法运行结束了.整个对象才算是建立完成
 */
public class Test {
	public static void main(String[] args) {
		/*Person p = new Person("3", 15);
		Person c = new Person();*/
	}
}
