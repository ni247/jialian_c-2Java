package lx_89;

import org.junit.Test;

public class Tank {
	public int state = 1;

	public Tank(int i) {
		state = i;
	}

	@Override
	protected void finalize() throws Throwable {
		if (state == 0) {
			super.finalize();
			System.out.println("这样子我才能释放");
		}
	}

	public static void main(String[] args) {
		Tank t = new Tank(0);
		t = null;
		System.gc();
	}

	public void lx12_1() {
		Tank t = new Tank(2);
		t = null;
		System.gc();
	}

	public void lx12_2() {
		Tank t = new Tank(1);
		t = null;
		System.gc();
	}
}
