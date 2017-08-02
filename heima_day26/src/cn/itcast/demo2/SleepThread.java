package cn.itcast.demo2;

public class SleepThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}
