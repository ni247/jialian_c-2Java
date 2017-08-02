package cn.itcast.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* java ｃｈａｒ是用ｕｎｉｃｏｄｅ标识的．两个字节
 * ｊａｖａ中其他都是用系统默认编码表
 * 
 * 文字编程数字－编码　　＂ａｂｃ＂．ｇｅｔＢｙｔｅｓ（）　
 * 数字转换为文字：解码　　ｂｙｔｅ［］　ｂ＝｛９７，９８，９９｝　ｎｅｗ　Ｓｔｒｉｎｇ　（ｂ）
 * 
 * 
 * 字节流复制文件
 *   采用数据缓冲提高效率
 *   字节数组
 *   FileInputStream 读取字节数组
 *   FileOutStream 写字节数组
 */
public class Copy_1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		//这里使用计时器 system.currentTimeMillis
		long s = System.currentTimeMillis();
		try {
			fis = new FileInputStream("D:" + File.separator + "b.exe");
			fos = new FileOutputStream("E:" + File.separator + "b.exe");
			byte[] bytes = new byte[1024 * 10];
			int len = 0;
			while ((len = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}
		} catch (IOException e) {
			throw new RuntimeException("文件复制失败");
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
			long e = System.currentTimeMillis();
			System.out.println(e - s);
		}
	}
}
