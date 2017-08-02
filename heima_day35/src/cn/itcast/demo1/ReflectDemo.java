package cn.itcast.demo1;

/*
 *  获取一个类的class文件对象的三种方式
 *  1.对象获取
 *  2.类名获取
 *  3.Class类的静态方法获取
 */
public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		//1.对象获取
		Person p = new Person();
		Class<?> personC = p.getClass();
		System.out.println(personC);

		//2.类名获取
		//每个类型,包括基本和引用,都会赋予一个静态的属性.属性名称class
		Class<?> d = Person.class;
		System.out.println(d);
		System.out.println(personC == d); //true
		System.out.println(personC.equals(d)); //true

		//静态方法获取
		//需要注意.写全名
		Class<?> b = Class.forName("cn.itcast.demo1.Person");
		System.out.println(b);
	}
}
