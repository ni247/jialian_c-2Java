package cn.itcast.demo1;

import java.io.File;

/*
 *  File类获取功能
 *  list 
 *  listFiles
 */
public class FileDemo {
	public static void main(String[] args) {
		function_2();
	}

	/*
	 *  静态方法listRoots
	 *  File[] listRoots
	 *  所有系统中的所有根目录
	 */
	static void function_2() {
		File[] arrFile = File.listRoots();
		for (File file : arrFile) {
			System.out.println(file);
		}
	}

	/*
	 * File类的获取功能
	 * File[] listFiles
	 * 获取File构造方法中封装路径中的文件和文件夹名
	 */
	static void function_1() {
		File file = new File("d:" + File.separator + "eclipse");
		File[] arrFiles = file.listFiles();
		for (File ss : arrFiles) {
			System.out.println(ss.getAbsolutePath());
		}
	}

	/*
	 * File类的获取功能
	 * String[] list()
	 * 获取到File构造方法中的封装的路径中的文件和文件夹名(遍历一个目录)
	 */
	static void function() {
		File file = new File("d:" + File.separator + "eclipse");
		String[] str = file.list();
		for (String s : str) {
			System.out.println(s);
		}
	}
}
