package cn.itcast.demo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 *  可能调用person方法,调用student方法,调用worker方法
 *  类不清楚,方法也不清楚
 *  通过配置文件实现此功能
 *    运行的类名和方法名字,已键值对的形式,卸载文本中
 *    运行哪个类,读取配置文件即可
 *  
 *  实现步骤:
 *    1.准备配置文件,键值对
 *    2.io流读取配置文件,reader
 *    3.文件中的键值对存储到集合中properties
 *      集合保存的键值对,就是类名和方法名
 *    4.反射获取指定类的class文件对象
 *    5.class文件对象,获取指定的方法
 *    6.运行方法
 */
public class Test {
	public static void main(String[] args) throws IOException, Exception {
		FileReader read = new FileReader("Test1.propertities");
		//创建集合对象,这里使用properties的方法load,加载reader子类
		Properties pro = new Properties();
		pro.load(read);
		read.close();
		//通过键获取值
		String className = pro.getProperty("className");
		String methodName = pro.getProperty("methodName");
		//反射
		Class<?> c = Class.forName(className);
		Object p = c.newInstance();
		Method m = c.getMethod(methodName);
		m.invoke(p);

	}
}
