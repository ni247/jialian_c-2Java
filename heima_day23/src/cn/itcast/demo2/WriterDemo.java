package cn.itcast.demo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  字符输出流
 *     java.io.Writer 所有字符输出流的超类
 *  只能写文本文件
 *  
 *  写的方法 write
 *    write(int c) 写一个字符
 *    write(char[] c) 写字符数组
 *    write(char[] c,int,int) 写一部分.开始索引,长度
 *    write(String s) 写入字符串
 *  
 *  Writer类的子类对象 FileWriter
 *  
 *  构造方法: 写入的数据目的
 *    File类型对象
 *    String 文件名
 *    
 *  字符输出流写数据的时候,必须要运行一个功能,刷新功能
 *  flush()
 */
public class WriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("D:" + File.separator + "a.txt");

		//写1个字符
		fw.write(100);
		fw.flush();
		//		fw.close();

		//写一个字符数组
		char[] c = { 'a', 'b', 'c', 'd', 'e' };
		fw.write(c);
		fw.flush();
		//		fw.close();

		//写数组的一部分
		fw.write(c, 2, 2);
		fw.flush();
		//		fw.close();

		//直接写字符串
		fw.write("123");
		fw.flush();
		fw.close();
	}

}
