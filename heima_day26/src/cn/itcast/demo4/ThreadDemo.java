package cn.itcast.demo4;

/*
 *  使用匿名内部类,实现多线程程序
 *  前提:继承或者接口实现
 *  new 父类或者接口(){
 *    重写抽象方法
 *  }
 *  
 *  timewait 等待休眠时间
 *  wait 永远等待(object方法),可以通过Thread的notify唤醒线程
 *  新的
 *  死亡
 *  受阻塞
 */
public class ThreadDemo {
	public static void main(String[] args) {

		//第一种
		new Thread() {
			public void run() {
				System.out.println("d");
			}
		}.start();

		//第二种
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("3");
			}
		};
		new Thread(r).start();

		//第三种
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(3);
			}
		}).start();
	}
}
