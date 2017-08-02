package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  IO流的异常处理
 *  try catch finally
 *  
 *  细节:
 *    1.保证流对象变量,作用域足够
 *    2.catch里面,怎么处理异常
 *      输出异常的信息,目的看到哪里出了问题
 *    3.如果流对象建立失败了,需要关闭资源
 *    new 对象的时候,失败 了.没有占用系统资源,释放资源的时候,需要判断是否为null
 *    如果为null,则不需要少
 */
public class FileOutputStreamDemo3 {
	public static void main(String[] args) {

		//try内遍历对象,
		//try外声明变量
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("D:" + File.separator + "a.txt");
			fos.write(100);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("文件写入失败");
		} finally {
			try {
				//需要注意这里可以这么写
				if (fos != null)
					fos.close();
			} catch (IOException e2) {
				throw new RuntimeException("关闭代码失败");
			}

		}

	}
}
