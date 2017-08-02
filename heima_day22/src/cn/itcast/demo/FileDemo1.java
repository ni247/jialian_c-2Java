package cn.itcast.demo;

import java.io.File;

/*
 *  File类的构造方法
 *  三种构造形式
 */

/*
 *  路径:
 *    绝对路径
 *      在系统中具有唯一性
 *      全称
 *    
 *    相对路径
 *      相对路径表示的路径之间的相对关系
 *      父母类-绝对路径
 *      子目录-可以使用相对路径表示
 */
public class FileDemo1 {
	public static void main(String[] args) {
		function_1();
	}

	/*
	 * File (File parent,String child)
	 * 传递路径,传递File类型父路径,字符串子路径
	 * 好处:父路径是File类型,可以直接调用File类的方法
	 */
	static void function_2() {
		File parent = new File("D:");
		File file = new File(parent, "eclipse");
		System.out.println(file);
	}

	/*
	 * File(String parent,Sting child)
	 * 参数传递的路径,传递字符串的父路径,字符串的子路径
	 * 这样子自由性更高
	 */
	static void function_1() {
		File file = new File("D:", "eclipse");
		System.out.println(file);
	}

	/*
	 * File(String pathName)
	 * 传递路径名,可以写到文件夹,可以写到一个文件.
	 * 将你的路径封装成File类型对象
	 */
	public static void function() {
		File file = new File("D:" + File.separator + "eclipse");
		System.out.println(file);
		System.out.println(file.exists());

	}
}
