package cn.itcast.demo_5;

/*
 * 也就是成员变量的默认(不写)修饰符是public 
 * 当遇到重名问题时,使用的是就近原则.
 * 可以使用this关键字:区分成员变量和局部变量同名情况
 * this.成员变量
 */

public class Person {
	private String name;
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void speak() {

	}
}
