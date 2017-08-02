package cn.itcast.demo08;

/*
 * 1.实现动物和cat和dog多台调用
 * 2.做类型的强制转换,调用子类的特有功能
 * 
 * 
 * 加上instanceof 可以提高安全性
 */
public class Test {
	public static void main(String[] args) {
		Animal a1 = new Cat();
		a1.eat();
		Animal a2 = new Dog();
		a2.eat();
		if (a1 instanceof Cat) {
			Cat c = (Cat) a1;
			c.catchMouse();
		}
		if (a2 instanceof Dog) {
			Dog d = (Dog) a2;
			d.kanMen();
		}
	}
}
