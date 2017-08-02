package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		function_2();
	}

	/*
	 *  File类的删除功能
	 *  boolean delete()
	 *  删除的文件或者是文件夹路径都在File构造函数中
	 *  删除方法,不走回收站,直接从硬盘中删除
	 *  如果下面有文件夹或者文件,则无法删除,也就是只能删除制定文件或下面没有文件夹或文件的文件夹
	 */
	static void function_2() {
		File f = new File("D:" + File.separator + "ddd");
		System.out.println(f);
		System.out.println(f.delete());
	}

	/*
	 *  File创建文件夹功能
	 *  boolean mkdir()---需要注意的是,这个只能创建单层文件夹
	 *  创建的路径也在File构造方法中给出
	 *  如果存在也就返回false
	 *  
	 *  boolean mkdirs()
	 *  可以创建多级文件夹.
	 */
	static void function_1() {
		File f = new File("D:" + File.separator + "ddd" + File.separator
				+ "ccc");
		System.out.println(f);
		System.out.println(f.mkdirs());
	}

	/*
	 *  File创建文件的功能
	 *  boolean createNewFile
	 *  创建的文件路径和文件名,是在File构造方法中给出
	 *  如果该文件已存在.则会返回false
	 *  只会创建文件.不能创建文件夹
	 */
	static void function() throws IOException {
		File f = new File("D:" + File.separator + "a");
		System.out.println(f.createNewFile());
	}

}
