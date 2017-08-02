package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 *  实现udp协议的发送端
 *    实现封装数据的类 java.net.Datagrampacket 将你的数据包包装
 *    实现数据传输的类 java.net.datagramsocket　将数据包发出去
 *  
 *  实现步骤：
 *  １.创建datagrampacket对象,封装数据,接受的地址和端口
 *  2.创建datagramsocket
 *  3.调用datagramsocket类方法send,发送数据包
 *  4.关闭资源
 *  
 *  datagrampacket构造方法
 *  datagrampacket(byte[] buf,int length,inetaddress address,int port)
 *  
 *  datagransocket构造方法:
 *    DatagranSocket()空参数
 *    方:send(DatagramPacket d)
 */
public class UDPSend {
	public static void main(String[] args) throws IOException {
		//创建数据包对象,封装要发送的数据,接收端ip,端口
		byte[] data = "你好udp".getBytes();
		//创建InetAddress对象,封装自己的IP地址
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);
		//创建datagramsoocket对象,数据包的发送和接受对象
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		//关闭资源
		ds.close();

	}
}
