package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  反射获取是有的构造方法运行
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//getDeclaredConstructors() 获取所有的构造方法,包括私有
		Constructor<?>[] cc = c.getDeclaredConstructors();
		for (Constructor<?> d : cc)
			System.out.println(d);
		//果然私有的也过去到了
		System.out.println("+++++++++++++++++++++++");
		//Constructor getDeclaredConstructor(Class...c) 获取到指定参数的构造方法
		Constructor<?> e = c.getDeclaredConstructor(int.class, String.class);
		System.out.println(e);

		//但是!!!!!!!!!!!!!!!
		//Constructor类,父类AccessibleObject,定义了方法setAccessibe
		//执行后,取消了检测运行时的权限检查.
		//
		e.setAccessible(true);
		//私有构造函数不能生成.下面会抛异常
		/*	Object b = e.newInstance(2, "4");
			System.out.println(b);*/

	}
}
