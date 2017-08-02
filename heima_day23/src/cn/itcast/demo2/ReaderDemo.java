package cn.itcast.demo2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 *  字符输入流读取文本文件,所有字符输入流的超类
 *  专门读取文本文件
 *  
 *  读取的方法:read()
 *  int read() 读取一个字符
 *  int read(char[] c) 读取字符数组
 *  
 *  Reader类是抽象类,找到子类对象FileReader
 *  
 *  如果读文本文件,推荐使用FilrReader类和FileWriter类
 *  
 */
public class ReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:" + File.separator + "a.txt");
		int len = 0;
		while ((len = fr.read()) != -1) {
			System.out.print((char) len);
		}
		//		fr.close();
		char[] ch = new char[1024];
		while ((len = fr.read(ch)) != -1) {
			System.out.println(new String(ch, 0, len));
		}
		fr.close();
	}
}
