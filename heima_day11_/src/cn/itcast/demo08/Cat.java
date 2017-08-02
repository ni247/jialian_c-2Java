package cn.itcast.demo08;

public class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("猫吃猫粮");
	}

	public void catchMouse() {
		System.out.println("猫抓老鼠");
	}

}
