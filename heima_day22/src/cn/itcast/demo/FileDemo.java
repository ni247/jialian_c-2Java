package cn.itcast.demo;

import java.io.File;

/*
 * 因为跨平台.所以尽量不写死
 */
public class FileDemo {
	public static void main(String[] args) {
		//目录分隔符 windows下是一个封号;
		//Linux  冒号 :
		//与系统有关的路径分隔符
		System.out.println(File.pathSeparator);

		//与系统有关的默认名称分隔符
		//window \  linux /
		System.out.println(File.separator);
	}
}
