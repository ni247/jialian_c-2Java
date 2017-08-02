package cn.itcast.demo;

/*
 *  创建和启动一个县城
 *    创建Thread子类对象
 *    子类对象调用方法start()
 *    让线程程序执行,jvm调用线程中的run
 *    需要注意的是start只能调用一次
 *    
 *  看源代码可以知道.因为run方法就是一个普通方法(要运行的方法)
 *  start才是真正的调用系统的native方法. 
 *  
 *   为什么要继承Thread
 *   因为需要Thread有线程方法
 *    
 */
public class ThreadDemo {
	public static void main(String[] args) {
		System.out.println("开始了");
		Thread st = new SubThread();
		st.start();
		for (int i = 0; i < 5000; i++) {
			System.out.println("++++++++++" + i);
		}
		System.out.println("结束了");
	}
}
