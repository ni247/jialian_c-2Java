package cn.itcast.demo1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *  字节输入流的缓冲流
 *  
 *  继承  InputStream 标准的字节输入流
 *  读取方法 read() 对单个字节,字节数组
 *  
 *  构造方法:
 *  BufferedInputStream (InputStream in)
 *  可以传递任意的字节输入流
 *  FileInputStream
 */
public class BufferedInputStreamdemo {
	public static void main(String[] args) throws IOException {
		/*System.out.println(System.in);
		function();*/
	}

	static void function() throws IOException {
		BufferedInputStream bos = new BufferedInputStream(new FileInputStream(
				"D:" + File.separator + "a.txt"));
		byte[] bytes = new byte[100];
		int len = 0;
		while ((len = bos.read(bytes)) != -1) {
			System.out.print(new String(bytes, 0, len));
		}
		bos.close();
	}
}
