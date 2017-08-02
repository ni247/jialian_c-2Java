package cn.itcast.demo;

import java.io.File;

public class FileDemo4 {
	public static void main(String[] args) {
		function_2();
	}

	/*
	 *  File判断功能
	 *  boolean isFile
	 *  如果是文件夹,返回true.不是返回false
	 */
	static void function_2() {
		File file = new File("src");
		System.out.println(file.isFile());
	}

	/*
	 *  File判断功能
	 *  boolean isDirectory
	 *  如果是文件夹,返回true.不是返回false
	 */
	static void function_1() {
		File file = new File("src");
		System.out.println(file.isDirectory());
	}

	/*
	 * File判断功能
	 * boolean exists()
	 * 判断文件是否存在,存在返回true
	 */
	static void function() {
		File file = new File("src");
		System.out.println(file.exists());
	}
}
