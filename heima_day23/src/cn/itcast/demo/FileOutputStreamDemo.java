package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  FileOutputStream
 *  写入数据文件,学习父类方法,使用子类对象
 *  
 *  子类中的构造方法:  作用: 绑定输出的文件
 *     参数:
 *     File  封装文件
 *     String 字符串
 *   流对象使用步骤:
 *     1.创建流子类的对象,绑定数据目的
 *     2.调用流对象的方法write写
 *     3.close 释放资源  
 *     
 *     注意:就写一个字节 write(int )写一个就字节
 *     
 *     流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File("D:"
				+ File.separator + "a.txt"));

		//		//write 写数据
		//写入了100的二进制100.也就是d.
		//写一个字节
		fos.write(49);
		fos.write(48);
		fos.write(48);

		//写字节数组
		byte[] bytes = { 65, 66, 67, 68 };
		fos.write(bytes);

		// 写字节数组的一部分
		fos.write(bytes, 1, 2);

		//写入字节数组的简便方式
		//写字符串
		fos.write("hello".getBytes());

		//		//关闭资源
		fos.close();
	}
}
