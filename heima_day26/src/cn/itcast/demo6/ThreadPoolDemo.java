package cn.itcast.demo6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
	public static void main(String[] args) throws Exception, Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> sum1 = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i < 101; i++) {
					sum += i;
				}
				return sum;
			}
		});
		Future<Integer> sum2 = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i < 201; i++) {
					sum += i;
				}
				return sum;
			}
		});
		System.out.println(sum1.get());
		System.out.println(sum2.get());
	}
}
