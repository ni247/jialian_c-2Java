package cn.itcast.copy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  字符流复制文本文件,必须文本文件
 *  字符流会查询本机默认的编码表.简体中文GBK
 *  FileReader读取数据源
 *  FileWriter写入到数据目的
 */
public class Copy_2 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		long s = System.currentTimeMillis();
		try {
			fr = new FileReader("d:" + File.separator + "a.txt");
			fw = new FileWriter("E:" + File.separator + "b.txt");
			char[] cBuff = new char[1024];
			int len = 0;
			while ((len = fr.read(cBuff)) != -1) {
				fw.write(cBuff, 0, len);
				fw.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("运行失败");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e2) {
					// TODO: handle exception
					throw new RuntimeException("释放资源失败");
				} finally {
					//先开后关
					//写在这里保证.保证读取流正常
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException e2) {
							throw new RuntimeException("释放资源失败");
						}
					}
				}
			}
			long e = System.currentTimeMillis();
			System.out.println(e - s);
		}
	}
}
