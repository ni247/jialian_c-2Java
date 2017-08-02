package cn.itcast.demo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 *  jdk1.5新特性,实现线程池特性
 *  使用步骤
 *  使用工厂类:
 *  Executors中的静态方法创建一个线程池对象,指定线程的个数
 *  static ExecutorService newFixedThreadPool(int 个数)
 *  返回线程池对象..
 *  返回的是实现Exectorserver接口的实现类
 *  
 *  接口实现类对象,调用方法submit(runnable r)调教线程执行任务
 *  
 *  
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//调用工厂类的静态方法,创建线程池对象
		//返回线程池对象,是返回的接口
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println(es);
		//调用接口实现类对象es中的方法submi提交线程任务
		//简单直接使用匿名函数做
		es.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程提交任务1");
				System.out.println(Thread.currentThread().getName());
			}
		});
		es.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程提交任务2");
				System.out.println(Thread.currentThread().getName());
			}
		});
		es.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程提交任务2");
				System.out.println(Thread.currentThread().getName());
			}
		});
		//需要注意的这样子是无法关闭的.(shutdown)

		Future<String> temp = es.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "0";
			}
		});
		System.out.println(temp);
		//销毁线程池
		es.shutdown();
	}
}
