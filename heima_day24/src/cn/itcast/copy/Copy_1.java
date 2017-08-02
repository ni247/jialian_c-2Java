package cn.itcast.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*  流的操作规律 总结
// *  四大源(抽象类): 
 *   inputStream 字节输入流(全能流)
 *   outputStream 字节输出流(全能流)
 *   Reader 字符(文本)输入流
 *   Writer 字符(文本)输出流
 *   
 *   注意:字节不建议打印出来.可能出现乱码
 *   
 *   inputStream 字节 
 *   outputStream 字节
 *   Reader 文本
 *   Writer 文本
 *   
 *   明确数据所在的具体设备
 *   硬盘:File 开头
 *   内存:数组,字符串
 *   键盘:System.in
 *   网络:socket
 *   
 *   明确是否需要额外功能:
 *   转换功能:
 *     转换流: InputStreamReader OutputStreamWriter
 *   提高速度:
 *     缓冲流: Buffered开头
 *     
 *   InputStream 
 *     FileInputStream
 *       BufferedInputStream
 *   OutputStream 
 *     FIleOutputStream
 *       BUfferedInputStream
 *   Writer
 *     OutputStreamWirter
 *       FileWriter
 *          BufferedWirter
 *   Reader 
 *     InputStreamReader
 *       FIleReader
 *         BufferReader           
 */

/*
 *  使用缓冲区流对象,复制文本对象
 *  数据源 BufferedReader+FileReader读取
 *  数据目的 BufferedWriter+FileWriter写入
 *  读取文本行,读一行,写一行,写换行
 */
public class Copy_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D:"
				+ File.separator + "a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:"
				+ File.separator + "b.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
			//会多一个空行,不影响
		}
		bw.flush();
		bw.close();
	}
}
