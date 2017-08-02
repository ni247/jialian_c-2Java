package cn.itcast.classes;

public class TestArgumentss {
	public static void main(String[] args) {
		// 匿名重写
		Animal d = new Animal() {

			@Override
			// 注解
			public void eat() {
				System.out.println("吃吃吃");
			}
		};
		operatorAnimal(d);
	}

	/*
	 * 该方法,参数是一个抽象类,只能传递一个子类过来(多态)
	 */
	public static void operatorAnimal(Animal a) {
		a.eat();
	}
}
