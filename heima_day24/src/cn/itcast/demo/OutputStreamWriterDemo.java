package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 *  OutputStreamWirter类可以将字符串转换为字节,转换的编码可以自己设置
 *  
 *   OutputStreamWriter(OutputStream out) 接受所有的字节输出流
 *   目前:字节输出流:FileOutStream 
 *   
 *   OutputStreamWriter(OutputStream out,String charsetName)
 *   String charsetName 传递编码表名字,不区分大小写
 *   
 *   FileWriter(不能改编码表) OutputStreamWriter (能改编码表)
// *   InputStreamReader 是字节流通向字符流的桥梁
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		writeUTF8();
	}

	/*
	 *  转换流对象OutputStreamWriter写文本
	 *  采用UTF-8编码写入
	 */
	static void writeUTF8() throws IOException {
		FileOutputStream fos = new FileOutputStream("D:" + File.separator
				+ "b.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		osw.write("你好么啊");
		osw.flush();
		osw.close();
	}

	/*
	 *  使用转换流对象 OutputStreamWriter写文本
	 *  文本采用GBK的形式写入
	 */
	static void writeGBK() throws IOException {
		//创建字节输出流,绑定数据文件
		FileOutputStream fos = new FileOutputStream("D:" + File.separator
				+ "a.txt");
		//创建转换流对象,构造方法,绑定字节输出流,使用GBK编码表
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		//转换流写数据
		osw.write("你好");
		//字符输出流写完必须刷新
		osw.flush();
		osw.close();

	}

}
