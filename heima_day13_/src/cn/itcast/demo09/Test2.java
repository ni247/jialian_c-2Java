package cn.itcast.demo09;

/*
 *  使用匿名可以简化代码
 *  
 */
public class Test2 {
	public static void main(String[] args) {
		Animal cat = new Animal() {

			@Override
			public void eat() {
				System.out.println("猫也在吃");
			}

			@Override
			public void sleep() {
				System.out.println("猫也在睡");
			}
		};
		cat.eat();
		cat.sleep();
	}
}
