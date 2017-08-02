package cn.itcast.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  将数据源c:\\a.txt
 *  复制到d:\\a.txt 数据
 */
public class copy {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;

		try {
			fos = new FileOutputStream("E:" + File.separator + "a.txt");
			fis = new FileInputStream("D:" + File.separator + "a.txt");
			int len = 0;
			//读一个写一个
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
		} catch (IOException e) {
			throw new RuntimeException("文件复制失败");
			// TODO: handle exception
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e2) {
					// TODO: handle exception
					throw new RuntimeException("释放资源失败");
				} finally {
					//先开后关
					//写在这里保证.保证读取流正常
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e2) {
							throw new RuntimeException("释放资源失败");
						}
					}
				}
			}
		}
	}
}
