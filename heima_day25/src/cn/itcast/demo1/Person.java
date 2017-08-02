package cn.itcast.demo1;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */

	//这行代码,类自定义了序列号.编译器不会计算序列号
	private static final long serialVersionUID = 4084204671889216292L;
	private String name;
	private transient int age;

	//transient关键字 阻止成员变量序列化  
	//称为瞬态关键字

	public Person() {
		super();
	}

	public Person(String name, int ages) {
		super();
		this.name = name;
		age = ages;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int ages) {
		age = ages;
	}
}
