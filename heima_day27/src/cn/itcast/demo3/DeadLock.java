package cn.itcast.demo3;

public class DeadLock implements Runnable {

	private int i = 0;

	public void run() {

		while (true) {
			if (i % 2 == 0) {
				synchronized (LockA.LOCKA) {
					System.out.println("if...locka");
					synchronized (LockB.LOCKB) {
						System.out.println("if...lockb");
					}
				}
			} else {
				synchronized (LockB.LOCKB) {
					System.out.println("else...lockb");
					synchronized (LockA.LOCKA) {
						System.out.println("else...locka");
					}
				}			
			}
			i++;
		}
	}
}
