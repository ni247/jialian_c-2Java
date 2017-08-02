package cn.itcast.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  转换流
 *    java.io.InputStreamReader 继承Reader
 *    字符输入流,读取文本文件
 *    
 *    字符流向字符的桥梁,将字节流转换为字符流
 *    
 *    read()  读取1个字符,读取字符数组
 *    技巧:OutputStreamWriter写文件
 *    
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		readGBK();
	}

	static void readUTF() throws IOException {
		//		FileInputStream fis = new FileInputStream("D:" + File.separator
		//				+ "a.txt");
		//		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	}

	/*
	 *  转换流,InputStreamReader读取文件
	 *  采用系统编码表,读取GBK文件
	 */
	static void readGBK() throws IOException {
		//创建自己输入流,传入文本文件
		FileInputStream fis = new FileInputStream("D:" + File.separator
				+ "a.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		int len = 0;
		char[] ch = new char[1024];
		while ((len = isr.read(ch)) != -1) {
			System.out.println(new String(ch, 0, len));
		}
		isr.close();
	}
}
