package cn.itcast.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  同步锁使用的弊端:同步中嵌套了其他的同步,程序出现了无限等待,死锁
 */

/*
 * 使用jdk1.5才出现的lock,替换同步代码块,实现线程的安全性
 * Lock接口方法:
 *   lock() 获取锁
 *   unlock() 释放锁
 *  实现类 ReentrantLock   
 */

public class Tickets implements Runnable {
	//定义出售的票源
	private int ticket = 100;

	//在类的成员位置,创建Lock接口的实现类对象
	private Lock lock = new ReentrantLock();

	void sell(int num) {
		ticket -= num;
		System.out.println("我是" + Thread.currentThread().getName() + ",出售第"
				+ (100 - ticket));
		System.out.println("==================");
	}

	@Override
	public void run() {

		while (true) {
			sellTicket();
		}
	}

	void sellTicket() {
		lock.lock();
		try {
			if (ticket > 0) {
				//模拟卡机
				Thread.sleep(10);
				sell(1);
			} else
				return;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
