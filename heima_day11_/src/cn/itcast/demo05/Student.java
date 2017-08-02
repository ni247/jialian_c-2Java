package cn.itcast.demo05;

public class Student implements Smoking {

	@Override
	public void smoke() {
		System.out.println("学生在抽烟");
	}
}
