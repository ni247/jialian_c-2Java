package cn.itcast.demo03;

public abstract class Animal {
	public abstract void eat();

	public static Animal getInstance() {
		return new Cat();
	}
}