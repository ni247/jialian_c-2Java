package cn.itcast.demo3;

import org.apache.commons.io.FilenameUtils;

public class Commons_IODemo {
	FilenameUtils fis = null;

	public static void main(String[] args) {
		function();
	}

	/*
	 *  FilenameUtils类的方法
	 *  static String getExtension(String fileName)
	 *  获取文件名的扩展名
	 */
	public static void function() {
		String name = FilenameUtils.getExtension("a.txt");
		System.out.println(name);
	}
}
