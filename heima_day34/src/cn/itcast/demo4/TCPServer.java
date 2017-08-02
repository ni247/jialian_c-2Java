package cn.itcast.demo4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
 *  tcp图片上传服务器
 *  1.serversocket套接字对象,监听端口8000
 *  2.方法accept()获取客户端的链接对象
 *  3.客户端链接对象获取字节输入流,读取客户端图片
 *  4.创建File对象,绑定上传的文件夹
 *    判断文件夹是否存在,不存在则创建
 *  5.创建字节输出流,数据目的为File所在的文件夹 
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		//监听8000端口
		ServerSocket server = new ServerSocket(8000);
		//获取链接客户端的套接字
		Socket socket = server.accept();

		//防止文件同名被覆盖,从新定义文件名字
		//规则:域名+毫秒值+6位随机数
		String fileName = "itcast" + System.currentTimeMillis()
				+ new Random().nextInt(999999) + ".jpg";
		//创建文件夹,文件
		File file = new File("D:" + File.separator + "upload" + File.separator
				+ fileName);
		if (!file.exists())
			file.getParentFile().mkdirs();

		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		BufferedInputStream bis = new BufferedInputStream(in);
		int len;
		FileOutputStream fos = new FileOutputStream(file);
		while ((len = bis.read(data)) != -1) {
			fos.write(data, 0, len);
		}

		OutputStream out = socket.getOutputStream();
		out.write("上传成功".getBytes());

		socket.close();
		server.close();

	}
}
