package cn.itcast.demo1;

public class Person {
	public String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", getName()="
				+ getName() + ", getAge()=" + getAge() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
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

	Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/*private Person(int age, String name) {
		super();
		this.name = name;
		this.age = age;
	}*/

	public void setAge(int age) {
		this.age = age;
	}

	public int eat() {
		System.out.println("人在吃饭");
		return 1;
	}

}
