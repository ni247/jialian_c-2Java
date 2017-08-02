package cn.itcast.demo;

/*
 *  定义子类,继承Thread
 *  重写父类方法 run 
 */
public class SubThread extends Thread {
	public void run() {
		for (int i = 0; i < 5000; i++) {
			System.out.println(i);
		}
	}
}
