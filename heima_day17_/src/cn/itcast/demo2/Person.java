package cn.itcast.demo2;

public class Person {
	public void finalize() {
		System.out.println("垃圾收取了");
	}
}
