package cn.incast.demo04;

/*
 *  子类中,super()的方式,调用父类的构造方法
 *  super()调用的是父类的空参数构造
 *  super(参数) 调用的是父类的有参数构造方法
 *  
 *  在子类,构造函数中,使用super(参数)调用父类的带参数的构造函数
 *  注意:在子类构造方法的第一行,有一个隐式代码,super()
 *  
 *  如果不手写super(),自动添加
 *  
 *  内存关系
 *  继承:子类自动拥有父类的成员,所以父类先进去
 *  Person.class 先进去
 *  
 *  先开空间,在赋成员初始值
 *  
 *  构造器的第一行都是super(),需要注意的是前提调价你是下面没有super()
 *  
 */
public class Person {
	int j = 5;

	public Person() {
		j += 1;
		System.out.println("父类构造方法");
	}

	public Person(int i) {
		j += i;
		System.out.println("父类构造方法滴滴滴" + j);
	}
}
