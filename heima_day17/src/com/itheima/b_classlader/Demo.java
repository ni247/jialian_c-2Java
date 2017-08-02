package com.itheima.b_classlader;

import sun.net.spi.nameservice.dns.DNSNameService;

public class Demo {
	public static void main(String[] args) {
		ClassLoader classLoader = Demo.class.getClassLoader();
		System.out.println(classLoader);
		// sun.misc.Launcher$AppClassLoader@198cb3d

		ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
		System.out.println(classLoader2);
		// sun.misc.Launcher$ExtClassLoader@472d48

		ClassLoader classLoader3 = String.class.getClassLoader();
		System.out.println(classLoader3);
		// null
	}
}
