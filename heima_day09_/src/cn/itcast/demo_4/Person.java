package cn.itcast.demo_4;

/*
 * 对私有变量,提供公共的访问方式:公共方法 get set
 * 类中所有的属性(成员变量) 都应该是私有的.
 * 应该对其进行get和set,以便外面能访问
 */
public class Person {
	// 人的姓名,成员变量
	String name;
	private int age;

	/*
	 * 方法必须set开头? 必须
	 */
	public void setAge(int ageI) {
		if (ageI < 20 || ageI > 200)
			age = 20;
		age = ageI;
	}

	public int getAge() {
		return age;
	}

	public void speak() {
		System.out.println(name + age);
	}
}
