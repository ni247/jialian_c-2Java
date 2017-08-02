package cn.itcast.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*  对象中的数据,以流的形式,写入到文件中保存,过程称为写出对象,对象的序列化.
 *  
 *  ObjectOutputStream 将对象写到文件中,叫做序列化
 *  
 *  在文件中,以流的形式,将对象读取出来,读取对象,叫做的返学咧
 *  
 *  ObjectInputStream将文件对象读取出来
 * 
 *  
 *  集合对象Properties类,继承HashTable,实现Map接口
 *  可以和IO对象结合使用,实现数据的持久存储
 */
public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		function_2();
	}

	/*
	 * 
	 * Properties集合的特有方法strore
	 * store(OutputStream )
	 * store(Writer)
	 */
	static void function_2() throws IOException {
		Properties pro = new Properties();
		pro.setProperty("da", "1");
		pro.setProperty("da1", "11");
		pro.setProperty("da11", "111");
		FileWriter writer = new FileWriter("D:" + File.separator
				+ "pro.properties");
		//这边是将中文转unicode存进来的
		//所以会出现乱码
		pro.store(writer, "abc");
		writer.close();
	}

	/*
	 * Properties集合特有方法,load
	 * load(InputStream)
	 * load(Reader)
	 */
	static void function_1() throws IOException {
		Properties pro = new Properties();
		//这里不能使用匿名函数.不能关闭了
		//注意这个文件的命名规范 ***.properties
		FileReader fr = new FileReader("D:" + File.separator + "pro.properties");
		pro.load(fr);
		fr.close();
		//也可以注意这个文件.可以使用注释 #
		//文件中两个不能有多余的空格.可以有换行
		System.out.println(pro);

	}

	/*
	 * 使用Properties集合,存储键值对
	 * setProperty等同与Map接口中的put(String,String)
	 * getProperty等于与map接口中的get(String)
	 */
	static void function() {
		Properties pp = new Properties();
		pp.setProperty("01", "张三");
		pp.setProperty("02", "李四");
		pp.setProperty("03", "王五");
		System.out.println(pp.getProperty("01"));
		System.out.println(pp);
		System.out.println(pp.getClass());

		//		Set<String> set = pp.stringPropertyNames();
	}
}
