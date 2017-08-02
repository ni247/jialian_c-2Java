package cn.itcast.demo03;

import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		/*
		 * 直接调用抽象类的静态方法getInstance()获取抽象类的子类的对象 抽象类的静态方法,反悔了自己的子类对象
		 * 对于调用者来将,不需要关注子类是谁 因为父类的方法,子类必须有
		 */
		Animal d = Animal.getInstance();
		d.eat();

		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}
}
