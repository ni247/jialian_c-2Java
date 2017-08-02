package cn.itcast.demo07;

/*
 * 运算符: 比较运算符结果真假值
 * 关键字:instanceof,解释:实例,运算符.比较引用数据类型
 * 
 * 关键字 instanceof比较,一个引用类型的变量,是不是这个类型的对象
 * p变量时student类型的对象,还是Teacher类型的对象
 * 
 * 使用格式
 * 引用变量 instanceof Student 比较p是不是Studnt类型的喜爱那个,如果是则返回true 
 * 
 * 需要特别注意的是Elipse不能智能出instanceof,实例的哪个成员
 * 可以通过instanceof关键字判断某个对象是否属于某种数据类型
 * 
 * 多台的根本是继承和实现,和自动类型转换
 */
public class Test {
	public static void main(String[] args) {
		// Person p = new Student();
		Person p = new Teacher();
		boolean b = p instanceof Teacher;
		System.out.println(b);
		p.sleep();

	}
}
