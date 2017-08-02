package cn.itcast.demo07;

/*
 * 抽象类中可以定义非抽象方法.目的是让继承的子类直接使用父类的方法
 */
public abstract class Animal {
	public void setSum() {
		System.out.println("达到");
	}
}
