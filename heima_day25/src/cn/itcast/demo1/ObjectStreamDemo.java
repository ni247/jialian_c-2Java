package cn.itcast.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*  标记性接口.Serializable
 *  没有方法的接口就称为标记性接口 
 * 
 * 
 *  特别注意:静态成员不能序列化,那为什么为0还是空.是因为成员变量初始值为0或者""(不全对)
 *   
 *  IO流对象,实现对象Person序列化和反序列化
 *  ObjectOutputStream 写对象,实现序列化
 *  ObjcectInputStream 读对象,反序列化
 */
public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		//		writePersonObject();
		readPersonObject();
	}

	/*
	 *  ObjectInputStream
	 *  构造方法:ObjcectInputStream(FileInputStream)
	 *  方法 
	 *  object readObject()
	 */
	static void readPersonObject() throws IOException, IOException,
			ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:"
				+ File.separator + "person.txt"));
		//readObject 抛出两个异常
		//IO异常
		//ClassNotFoundException异常
		//需要注意的话,如果文件夹下没有改类的class文件.则回抛出改异常
		Object p = (ois.readObject());
		ois.close();
		System.out.println(p);
	}

	/*
	 * ObjectOutputStream
	 * 构造方法:ObjectOutputStream (OutputStream out)
	 * 传递任意的字节输出流
	 * void writeObject(Object obj) 写出对象的方
	 */
	static void writePersonObject() throws IOException {
		FileOutputStream fos = new FileOutputStream("D:" + File.separator
				+ "person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person("a", 3);
		oos.writeObject(p);
		oos.close();

	}
}
