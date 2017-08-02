package cn.itcast.demo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadServer {
	public static void main(String[] args) throws IOException {
		//监听8000端口
		ServerSocket server = new ServerSocket(8000);
		//获取链接客户端的套接字
		Socket socket;
		while (true) {
			socket = server.accept();
			new Thread(new Upload(socket)).start();
		}
	}
}
