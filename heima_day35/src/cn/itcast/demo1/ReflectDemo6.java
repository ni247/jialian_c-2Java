package cn.itcast.demo1;

import java.lang.reflect.Method;

/*
 *  反射获取成员方法并运行
 *  public void eat()
 */
public class ReflectDemo6 {
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//获取class对象中的成员方法
		//Method[] getMethods() 获取的是class文件中的所有公共成员方法,包括继承的
		//method类是描述成员方法的对象
		/*	Method[] methos = c.getMethods();
			for (Method m : methos)
				System.out.println(m);*/
		Object p = c.newInstance();
		//获取class对象中单个成员方法
		Method m = c.getMethod("eat");
		System.out.println(m);
		//执行方法
		Object ccc = m.invoke(p);
		System.out.println(ccc);
	}
}
