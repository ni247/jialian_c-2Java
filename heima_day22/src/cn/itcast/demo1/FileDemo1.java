package cn.itcast.demo1;

import java.io.File;

/*
 * File类的获取,文件获取过滤器
 * 遍历目录的时候.可以根据需要,只获取满足条件的文件
 */
public class FileDemo1 {
	public static void main(String[] args) {
		File file = new File("d:" + File.separator + "demo");
		File[] arrFile = file.listFiles(new MyFileter());
		for (File f : arrFile)
			System.out.println(f);
	}
}
