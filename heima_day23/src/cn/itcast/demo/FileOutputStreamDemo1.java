package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  FileOutputStream 文件的续写和换行问题
 *  通过FileOutputStream构造器,file,true 来追加写入
 *  
 *  在文件中,写入换行,符号换行. \r\n
 *  注意,字符串中直接就是\r\n就行,因为就是需要他们转移的作用
 */
public class FileOutputStreamDemo1 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "a.txt");
		//续写-通过构造器 第二个参数传true
		FileOutputStream fos = new FileOutputStream(file, true);
		fos.write("\r\n".getBytes());
		fos.write("www".getBytes());
		fos.close();
	}
}
