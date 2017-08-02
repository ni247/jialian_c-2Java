package cn.itcast.demo1;

/*
 *  线程打印出来命名方式 Thread-0 每个线程都有自己的名字
 *  运行方法main的线程,名称就是main
 *  多线程其他都是Thread-编号
 *  
 *  获取线程名称 
 *  线程对象调用 getName()
 *  
 *  如果获取主线程的名字
 *  jvm开启主线程,运行方法main  主线程也是线程,是线程必然也就是Thread类对象
 *  Thread类中,定义了一个静态方法
 *  static Thread currentThread() 返回正在执行的线程对象,然后就可以打印出来getNama方法了
 *  
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//		System.out.println(0 / 0);
		NameThread nt = new NameThread();
		NameThread nt1 = new NameThread();
		System.out.println(nt.getName());
		System.out.println(nt1.getName());
		nt.setName("main");
		//线程名可以重复
		//需要注意的主线程的名字改不了
		System.out.println(nt.getName());
		nt.start();
		nt1.start();

		System.out.println(Thread.currentThread().getName());
		//这是一个比较通用的方法.在任意线程方法中都可以使用
	}
}
