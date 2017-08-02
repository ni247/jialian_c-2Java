package cn.itcast.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 *  实现tcp客户端,连接到服务器
 *  和服务器实现数据交换
 *  实现tcp客户端程序的类 java.net.socket
 *  
 *  构造方法:
 *    socket(String host,int port) 传递服务器ip和端口号
 *    注意:构造函数只要运行,就会和服务器进行连接,连接失败,抛出异常
 *    
 *   outputStream getOutputStream() 返回套接字的输出流
 *    作用:将数据输出,到服务器
 *    
 *    inputStream getInputStram() 返回套接字的输入流
 *     作用:从服务器端读取数据
 *    
 *    需要注意:客户端服务器数据交换,必须使用套接字对象socket中获取的io流,自己new流是不行
 *    固定的连接通道
 */
public class TCPClient {
	public static void main(String[] args) throws IOException, IOException {
		// 需要注意:创建时候回直接链接服务器
		// ip,端口号
		Socket socket = new Socket("127.0.0.1", 8888);
		// 通过客户端的套接字对象socket方法,获取字节输出流,将数据写向服务器
		OutputStream out = socket.getOutputStream();
		out.write("你好,服务器".getBytes());
		// 注意不要关流

		// 读取服务器发回来的数据
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data, 0, len));

		socket.close();
	}
}
