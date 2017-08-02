package cn.itcast.demo2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *  打印流 
 *  PrintStream --永远不会抛出异常
 *  PrintWriter
 *  
 *  特点:
 *      1.不负责数据源,只负责打印数据
 *      2.为其他输出流,添加功能
 *      3.永远不会抛出IOexception,但是可能抛出其他异常
 *      
 *      两个打印流的方法,完全一致
 *       构造方法,就是打印流的输出目的端
 *       PrintStream 
 *         构造方法,接收File类型,接收字符串文件名,接收字节输出流OutputStream
 *       PrintWriter(多一个Wirter)
 *         构造 方法,接收File类型,接收字符串文件名,接收字节输出流outputStream,接收字符输出流Writer
 *      
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws IOException {
		function_4();
	}

	/*
	 *  打印流,可以开启自动刷新功能
	 *  满足两个条件:
	 *    1.输出的数据谜底必须是流对象
	 *      outputstream writer
	 *    2.必须调用Println,printf,format三个方法中1个,启动自动刷新
	 *    
	 */
	static void function_4() throws IOException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("D:"
				+ File.separator + "c.txt"), true);
		pw.println(1);
		pw.println(3);
		pw.println(4);
		pw.close();
	}

	/*
	 * 打印流,输出目的,是流对象
	 * 可以是字节输出流,可以是字符输出流
	 * OutputStream Writer----这两个是抽象类,需要使用它们的子类
	 */
	static void function_3() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("D:" + File.separator
				+ "c.txt"));
		pw.println(3533);
		pw.flush();
		pw.close();
	}

	/*
	 * 打印流,输出目的,是流对象
	 * 可以是字节输出流,可以是字符输出流
	 * OutputStream Writer
	 */
	static void function_2() throws IOException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("D:"
				+ File.separator + "c.txt"));
		pw.println(333);
		pw.flush();
		pw.close();
	}

	/*
	 *  打印流,输出目的,直接写String文件名
	 */
	static void function_1() throws IOException {
		PrintWriter pw = new PrintWriter("D:" + File.separator + "c.txt");
		pw.println(3.5);
		pw.close();
	}

	/*
	 *  打印流,向File对象的数据目的的写入数据
	 *  方法 print println
	 *  需要特别注意:
	 *  write方法会走码表
	 *  print方法会原样输出
	 */
	static void function() throws IOException {
		File file = new File("D:" + File.separator + "c.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.println(100);
		pw.write(100);
		pw.println();
		pw.print(true);
		pw.flush();
		pw.close();
	}

}
