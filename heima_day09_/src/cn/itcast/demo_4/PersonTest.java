package cn.itcast.demo_4;

/*
 * 提高安全问题:让外面的类,不允许直接调用我的成员变量
 * 新的关键字 private 私有变量.成员修饰符
 * 
 * 需要特别注意的是,因为String是引用变量,赋予默认值的时候是null
 */
public class PersonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "张三";
		// p.age=16;
		p.setAge(20);
		p.speak();
	}

}
