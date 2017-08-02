package homeWork1_2;

public class Person {
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

	private String name;
	private int age;

	public void EatFan() {
		System.out.println("大家一起来吃饭");
	}
}
