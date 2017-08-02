package cn.itcast.demo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 *  其中callable可以有返回值,可以抛出异常
 *  runnable不可以有返回值,不可以抛出异常
 */
public class ThreadPoolDemo1 {
	public static void main(String[] args) throws Exception, Exception {
		ExecutorService er = Executors.newFixedThreadPool(2);
		Future<String> f = er.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "2";
			}
		});
		System.out.println(f.get());
	}
}
