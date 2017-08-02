package cn.incast.demo04;

public class Student extends Person {
	int a = 3;

	public Student(int i) {
		// 也就是这里系统默认加了一个父类的构造方法.
		// super()
		// 如果下面默认自己写了super,则默认super()消失
		super(1);
		a = 5;
	}
}
