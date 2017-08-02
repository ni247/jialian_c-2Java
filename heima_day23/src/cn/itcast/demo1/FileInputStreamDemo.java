package cn.itcast.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *  FileInputStream读取文件
 *  
 *  构造方法:为这个流对象绑定数据源
 *  
 *    参数:
 *      File类型对象
 *      String 对象
 *   输入流读取文件的步骤
 *     1.创建字节输入流的子类对象
 *     2.调用读取方法read读取
 *     3.关闭资源
 *     
 *   read方法,
 *   执行一次,就会自动读取下一个字节,返回值,就是读取到的字节.读取到文件的结果,方法将返回-1  
 */
public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:" + File.separator
				+ "a.txt");
		//读取一个字节,调用read,返回int
		int i = 0;
		//直接在while读取直接赋值然后判断是否等于-1
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		//关闭资源
		fis.close();
	}
}
