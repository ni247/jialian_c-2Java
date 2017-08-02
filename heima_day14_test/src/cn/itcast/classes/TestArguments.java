package cn.itcast.classes;

/*
 *   将person类当做一个参数
 *   person类型写在方法的参数列表中
 */
public class TestArguments {
	public static void main(String[] args) {
		operatorPerson(new Person());
		GetPerson p = new GetPerson();
		operatorPerson(p.get());
	}

	public static void operatorPerson(Person p) {
		// 可以使用引用类型p调用person类的功能
		p.eat();
		p.run();
	}
}
