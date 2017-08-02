package cn.itcast.demo2;

import java.io.File;

/*
 *  对一个目录下的所有内容,进行完全遍历
 *  
 *  编程技巧:方法的递归调用
 */
public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("d:" + File.separator + "eclipse");
		getAllDir(dir);
	}

	/*
	 *  定义方法,实现目录的全目录
	 */
	static void getAllDir(File dir) {
		System.out.println(dir);
		File[] arrFiles = dir.listFiles();
		for (File file : arrFiles) {
			if (file.isDirectory()) {
				/*				File[] neibuFiles = file.listFiles();
								for (File neibuFile : neibuFiles)
									System.out.println(neibuFile);*/
				getAllDir(file);
				//重复调用自己
			} else
				System.out.println(file);
		}
	}
}
