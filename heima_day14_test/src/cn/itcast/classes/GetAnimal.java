package cn.itcast.classes;

public class GetAnimal {
	/*
	 * 定义方法,方法返回值为animal
	 */
	public static Animal getAnimal() {
		return new Animal() {

			@Override
			public void eat() {
				System.out.println("我是在吃的啊");
			}
		};

	}
}
