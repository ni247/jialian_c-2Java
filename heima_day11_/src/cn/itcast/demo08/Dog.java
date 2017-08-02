package cn.itcast.demo08;

public class Dog extends Animal {

	@Override
	public void eat() {
		System.out.println("狗吃狗粮");
	}

	public void kanMen() {
		System.out.println("狗可以看家");
	}

}
