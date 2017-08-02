package cn.itcast.demo3;

public class SubRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(i);
		}
	}

}
