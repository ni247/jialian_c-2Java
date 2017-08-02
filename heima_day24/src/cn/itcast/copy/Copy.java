package cn.itcast.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) throws IOException {
		File src = new File("D:" + File.separator + "1.iso");
		File desc = new File("D:" + File.separator + "2.iso");
		long s = System.currentTimeMillis();
		/*copy_1(src, desc);
		System.out.println((System.currentTimeMillis() - s) / 1000);*/
		System.out.println("=======================");
		s = System.currentTimeMillis();
		copy_2(src, desc);
		System.out.println((System.currentTimeMillis() - s) );
		System.out.println("=======================");
		s = System.currentTimeMillis();
		copy_3(src, desc);
		System.out.println((System.currentTimeMillis() - s) );
	}

	/*   实现文件复制
	 *   方法3  缓冲字节流读写数组
	 */
	static void copy_3(File src, File desc) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(desc);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = 0;
		byte[] bytes = new byte[1024 * 10];
		while ((len = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		fis.close();
		fos.close();
	}

	/*   实现文件复制
	 *   方法2 字节流读写数组
	 */
	static void copy_2(File src, File desc) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(desc);
		int len = 0;
		byte[] bytes = new byte[1024 * 10];
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);
		}
		fis.close();
		fos.close();
	}

	/*   实现文件复制
	 *   方法1 字节流读写单个字节
	 */
	static void copy_1(File src, File desc) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(desc);
		int len = 0;
		while ((len = fis.read()) != -1) {
			fos.write(len);
		}
		fis.close();
		fos.close();
	}
}
