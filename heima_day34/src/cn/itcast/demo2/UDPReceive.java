package cn.itcast.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 实现udp接收端
 *   实现封装数据包 java.net.datagrampacket 将数据接收
 *   实现输出传输 java.net.datagramsocket接受数据包
 *   
 *   实现步骤:
 *    1.创建DataGramSocket对象,绑定一个端口号
 *      要和发送端端口号一致
 *    2.创建一个字节数组,接受发来的数据  
 *    3.创建数据包对象DataGramPacket
 *    4.调用DatagramSocket对象方法
 *    Receive(DataGramPocket dp)接受数据,数据放在数据包中
 *    5.拆包
 *      发送的ip地址
 *        数据包对象DatagramPacket方法getAddress(),获取inetadress对象,在进行调用gethostaddress
 *      接受到的字节个数
 *        数据包对象DatagramPacket方法getLength(),拿到有效字节个数
 *      发送方的端口号
 *        数据包对象DatagramPacket方法getPort()
 *    6.关闭资源
 *    
 */
public class UDPReceive {
	public static void main(String[] args) throws Exception {
		int length;
		DatagramSocket ds = new DatagramSocket(6000);
		byte[] bf = new byte[1024]; //最大发送64kb
		//创建数据包对象,传递字节数组

		//这边第二个参数是用多少长度来接收
		DatagramPacket dp = new DatagramPacket(bf, bf.length);
		//调用ds对象的方法receive方法传递数据包
		//receive具有线程阻塞效果
		while (true) {
			ds.receive(dp);

			//获取接收到的字节个数
			length = dp.getLength();
			//拆包
			//使用String构造函数,将字节数组转换为String
			System.out.println("发送端消息如下");
			System.out.println("IP:" + dp.getAddress().getHostAddress());
			System.out.println("port:" + dp.getPort());
			System.out.println("传送数据:" + new String(bf, 0, length));
		}
		//		ds.close();
	}
}
