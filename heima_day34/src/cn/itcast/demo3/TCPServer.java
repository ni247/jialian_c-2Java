package cn.itcast.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ???tcp??????????
 * ????????????????: java.net.serverSocket
 * ??????:
 *   serversocket(int port) ???????
 *   
 * ???????????:?????????????????????socket
 * socket accpet()
 *   
 * 
 * 
 * 
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		System.out.println(socket);

		InputStream input = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = input.read(data);
		System.out.println(new String(data, 0, len));
		OutputStream out = socket.getOutputStream();

		out.write("输出".getBytes());
		socket.close();
		server.close();
	}
}
