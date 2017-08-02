package cn.itcast.demo01;

public class TestEquals {
	public static void main(String[] args) {
		// Person类继承object类,继承下来了object的方法equals
		Person p1 = new Person("李四", 25);
		// Person p2 = new Person("李四", 25);
		System.out.println(p1.equals(null));
		// 会自动重写
		System.out.println(p1);
	}
}
