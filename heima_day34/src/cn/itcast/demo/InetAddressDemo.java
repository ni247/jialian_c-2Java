package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 表示互联网中的ip地址
 * java.net.inetaddress
 * 
 * 静态方法
 * static inetadress getLocalHost() localHost本地主机
 * 返回本地主机,返回值inetAddress对象
 * 
 * static inetaddress getbyName(string hostname)
 * 传递主机名,获取主机的ip地址(获取别人的ip)
 * 
 * 非静态方法
 * String gethostaddress() 获取主机ip地址
 * String gethostname() 获取主机名
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		function_1();
	}

	static void function_1() throws UnknownHostException {
		//这里写主机名,ip都可以
		//		InetAddress inet = InetAddress.getByName("DESKTOP-BFPNF28");
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		System.out.println(inet);
	}

	/*
	 * static inetaddress getlocalHOst()
	 */
	static void function() throws UnknownHostException { //未知主机异常
		InetAddress inet = InetAddress.getLocalHost();
		//输出结果就是主机名,和ip地址
		System.out.println(inet);
		String[] arr = inet.toString().split("/");
		for (String str : arr)
			System.out.println(str);
		System.out.println("=====================");
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
	}
}
