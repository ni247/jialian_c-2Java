package cn.itcast.demo1;

import java.lang.reflect.Field;

/*
 *  反射获取成员变量,并修改值
 *  Person类中的成员String name
 */
public class ReflectDemo5 {
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> c = Class.forName("cn.itcast.demo1.Person");
		//获取成员变量Class类的方法getFields() class 文件中的所有公共的成员变量
		//返回值是Field[] field类描述成员变量对象的类 
		/*	Field[] f = c.getDeclaredFields();  //这是全部
			for (Field ff : f)
				System.out.println(ff);*/
		Object p = c.newInstance();
		//获取指定的成员变量String name
		//Class类方法 getField(传递字符串类型的变量名),获取指定的成员变量
		Field cd = c.getField("name");
		System.out.println(cd);

		//Field 类的方法 void set(object obj,object value) ,修改成员变量的值
		//object obj必须有对象的支持,object value修改后的值
		cd.set(p, "王五");
		System.out.println(p);

	}
}
