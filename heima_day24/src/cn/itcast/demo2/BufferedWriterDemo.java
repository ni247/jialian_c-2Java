package cn.itcast.demo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  字符输出流缓冲区流
 *  继承于Writer 
 *  写入方法 write() 单个字符,字符数组,字符串
 *  
 *  构造方法:
 *   　BufferedWriter(Writer w) 传递任意字符输出流
 *   传递谁,就高效谁
 *     能传递的字符输出流,FileWriter OutputStreamWriter
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("D:" + File.separator + "c.txt");
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write(100);
		bfw.flush();
		bfw.newLine(); //建议使用这个.因为各个平台不通
		bfw.flush();
		bfw.write("大家好\r\n");
		bfw.flush();
		bfw.write("你好".toCharArray());
		bfw.flush();

		bfw.close();
	}
}
