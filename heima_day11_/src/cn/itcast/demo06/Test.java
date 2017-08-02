package cn.itcast.demo06;
/*
 * 多态中,成员特点
 * 
 * 成员变量:
 * 编译的时候,参考父类中有没有这个变量,如果有,编译成功,没有,则编译失败
 * 运行的时候,使用的父类的成员变量
 * 
 * 成员方法:
 * 编译的时候,参考父类中有没有这个方法,如果有,编译成功,没有则编译失败
 * 运行的时候,运行的是子类的重写方法
 * 
 * 有重写则使用子类的方法成员.无则用自己父类的
 * 
 * 编译看父类,运行看子类
 */
public class Test {
	public static void main(String[] args) {
		Fu f = new Zi();
		System.out.println(f.a);
		f.show();
	}
}
