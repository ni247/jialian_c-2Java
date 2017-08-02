package cn.incast.demo03;

/*
 *  this可以在构造方法之间进行调用
 *  this.的方式,区分局部变量和成员变量同名情况
 *  this在构造方法之间的调用,语法this()
 *  
 *  this()代表的是构造函数
 *  需要注意的是this必须放在第一行
 * 
 */
public class Person {
	public Person() {

		this("5", 15);
		this.name = "55";
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

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
}
