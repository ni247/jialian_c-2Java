package cn.itcast.demo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 *   Java特点:
 *     获取内容的方法一般都有返回值
 *     int 没有返回的都是负数
 *     引用类型,找不到返回null
 *     boolean 找不到返回false
 * 
 *  java.io.BufferedReader 继承Reader
 *  读取功能read()  单个字符,字符数组
 *  
 *  构造方法: 
 *  BufferedReader(Reader r)
 *  //可以任意的字符输入流
 *  FileReader 
 *  InputStreamReader
 *  
 *  自己的功能
 *  String readLine() 读取文本中的行
 */
public class BufferReaderDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D:"
				+ File.separator + "a.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
