package cn.itcast.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *  FileInputStream读取键
 *  读取方法  
 *  int read(byte[] b) 读取字节数组
 *  数组的作用
 *  返回的int作用 返回多少个字节读取到的有效字节
 */
public class FileInputStreamDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:" + File.separator
				+ "a.txt");
		//创建字节数组
		//一般使用1024或者倍数
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fis.read(b)) != -1) {
			//使用起始量和偏移量的构造函数.
			System.out.print(new String(b, 0, len));
		}
		fis.close();
	}
}
