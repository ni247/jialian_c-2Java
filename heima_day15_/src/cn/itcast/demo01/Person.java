package cn.itcast.demo01;

public class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 重写object equals方法 前面两行代码提高程序的健壮性
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		else if (obj == this)
			return true;
		Person p = (Person) obj;
		return this.age == p.age ? true : false;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	/*
	 * 重写toString()
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name;
	}
}
