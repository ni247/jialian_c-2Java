package cn.itcast.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 *  泛型擦除
 *  定义集合类,泛型String 
 *  要求向集合中添加Integer类型
 *  
 *  反射方式,获取出集合ArrayList类的class文件对象
 *  通过class文件对象,直接调用add方法
 *  
 *  应用的原理的就是变异后的class文件,泛型是没有的.是object
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception, SecurityException {
		ArrayList<String> array = new ArrayList<String>();
		Class<?> c = array.getClass();
		//获取arraylist.class文件中的方法add
		//泛型就是Object.class
		Method m = c.getMethod("add", Object.class);
		System.out.println(m);
		m.invoke(array, 5);
		m.invoke(array, 5);
		m.invoke(array, 5);
		System.out.println(array);
		//没有太大实用价格.
		//对反射调用方法是否理解
	}
}
