package cn.itcast.demo;

import java.io.File;

public class FileDemo3 {
	public static void main(String[] args) {
		function_3();
	}

	/*
	 *  File类的获取功能
	 *  String getParent()
	 *  File getParentFile()
	 *  获取父路径
	 *  需要注意的是构造函数中需要传入绝对路径
	 *  
	 *  在系统中,盘符就是最高层了
	 */
	static void function_3() {
		File file = new File("D:\\eclipse\\eclipse.exe");
		String path = file.getParent();
		File file1 = file.getParentFile();
		System.out.println(path);
		System.out.println(file1);
	}

	/*
	 *  File类获取功能
	 *  String getAbsolutePath() 返回String对象
	 *  File getAbsoluteFile()   返回File对象
	 *  获取绝对路径
	 *  
	 *  eclipse环境中,写的是一个相对路径,绝对位置是工程的根目录
	 */
	static void function_2() {
		File file = new File("src");
		String path = file.getAbsolutePath();
		File file1 = file.getAbsoluteFile();
		System.out.println(path);
		System.out.println(file1);
	}

	/*
	 * File类获取功能
	 * long length()
	 * 返回路径中标识的文件的字节数
	 * 打印出来的是字节数
	 * 
	 * 文件夹本身没有字节概念,
	 * 如果获取的是文件夹length,有则4096,没有则0
	 */
	static void function_1() {
		//		File file = new File("D:\\eclipse\\eclipse.exe");
		File file = new File("D:\\doc");
		long length = file.length();
		System.out.println(length);
	}

	/*
	 *   File类的获取功能
	 *   String getName()
	 *   返回路径中标识的文件或者文件夹名
	 *   获取路径中最后部分的名字
	 */
	static void function() {
		File file = new File("D:\\eclipse\\eclipse.exe");
		String name = file.getName();
		System.out.println(name);
	}
}
