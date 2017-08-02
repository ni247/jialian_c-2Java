package cn.itcast.demo1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  字节输出流的缓冲流
 *  提高原有输出流的写入效率
 *  BUfferedOutputStream继承OutputStream
 *  方法,写入
 *  write 字节,字节数组
 *  
 *  构造方法 
 *  BufferedOutputStream(OutputStream out)
 *  可以传递任意的字节输出流.对传入的字节流提高效率
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream("D:" + File.separator + "a.txt"));
		bos.write("HelloWorld".getBytes());
		bos.flush();
		bos.close();
	}

}
