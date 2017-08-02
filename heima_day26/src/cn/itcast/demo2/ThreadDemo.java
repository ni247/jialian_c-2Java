package cn.itcast.demo2;

/*
 *  让线程暂时休眠
 */
public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		/*for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println(i);
		}*/
		new SleepThread().start();
	}
}
