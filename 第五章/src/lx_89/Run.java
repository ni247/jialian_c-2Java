package lx_89;

import org.junit.Test;

public class Run {
	public static void main(String[] args) {
		Run r = new Run();
	}

	int i = f();

	int f() {
		return 11;
	};

	int g(int n) {
		return n * 10;
	}

	@Override
	protected void finalize() throws Throwable {

		super.finalize();
		System.out.println("释放了");

	}

	@Test
	public void lx10() {
		Run r = new Run();
		r = null;
	}

	@Test
	public void lx11() {
		Run r = new Run();
		r = null;
		System.gc();
	}
}
