package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取class文件中的构造方法,运行构造方法
 * 运行构造方法,创建对象
 *   获取class文件对象
 *   从class文件对象中,获取需要的成员
 *   
 * Constuctor 描述构造方法对象的类  
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException,
			Exception, SecurityException {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//使用class文件对象,获取类方法
		//方法:Constructor[]  getConstructors() 获取class文件对象的所有公共权限的构造方法
		/*Constructor[] ctt = c.getConstructors();
		for (Constructor con : ctt) {
			System.out.println(con);
		}*/

		//获取指定的构造方法,空参数的构造方法
		//方法：Constructor getConstructor()
		Constructor<?> con = c.getConstructor();
		System.out.println(con);
		//运行空参数构造方法,Constructor类方法 newInstance()运行获取到的构造方法
		Object pp = con.newInstance();
		System.out.println(pp);
		//需要强转为person才能用特色功能

	}
}
