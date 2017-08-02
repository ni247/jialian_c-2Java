package cn.itcast.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * 实现dup发送,键盘输入的形式
 * 输入完毕,发送给接收端
 */
public class UDPSend {
	public static void main(String[] args) throws IOException {
		//创建数据包对象,封装要发送的数据,接收端ip,端口
		byte[] data;
		//创建InetAddress对象,封装自己的IP地址
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp;
		DatagramSocket ds;
		while (true) {
			data = new Scanner(System.in).nextLine().getBytes();
			dp = new DatagramPacket(data, data.length, inet, 6000);
			//创建datagramsoocket对象,数据包的发送和接受对象
			ds = new DatagramSocket();
			ds.send(dp);
		}
		//关闭资源
		//		ds.close();
	}
}
