package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  通过反射,获取带有参数的构造函数
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//获取带有String int参数的构造方法
		//Constructor<T> getConstructor(Class<?>...parameterTypes)
		//Class<?>...parameterTypes 传递要获取的构造方法的参数列表
		Constructor<?> d = c.getConstructor(String.class, int.class);
		System.out.println(d);
		//运行构造方法,后面为传递的实际参数
		Object dd = d.newInstance("3", 2);
		System.out.println(dd);
	}

}
