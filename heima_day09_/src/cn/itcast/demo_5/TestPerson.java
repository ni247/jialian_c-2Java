package cn.itcast.demo_5;

public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(16);
		p.setName("张三");
		System.out.println(p.getAge() + p.getName());
	}

}
