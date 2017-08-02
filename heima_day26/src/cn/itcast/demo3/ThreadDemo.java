package cn.itcast.demo3;

import cn.itcast.demo.SubThread;

/*
 *  使用实现Runnable接口的线程方式
 *  
 *  实现接口方式的线程
 *    创建Thread类对象,构造方法中,传递Runnable接口实现
 *    
 *    调用Thread类方法start()
 *    也就是那个方法直接继承了实现接口
 *    
 *   推荐使用实现Runnable的方法.耦合性低.
 *   高内聚,低耦合(尽量降低类与类之间的耦合性)
 *   
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Thread th = new Thread(new SubThread());
		th.start();
	}
}
