package cn.itcast.demo12;

/*
 *   静态代码块,只执行一次
 *   构造代码块,new一次,就执行一次,优先于构造方法.
 *   
 */
public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
		System.out.println("我是构造方法");
	}

	// 构造代码块-次打印第二个打印
	{
		System.out.println("我是构造代码块");
	}
	// 静态代码块-先打印静态代码块.内存优先
	static {
		System.out.println("我是静态代码块");
	}
}
