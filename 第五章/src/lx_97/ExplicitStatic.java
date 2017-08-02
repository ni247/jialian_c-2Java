
package lx_97;

class Cup {
	Cup(int market) {
		System.out.println("Cup(" + market + ")");
	}

	void f(int market) {
		System.out.println("f(" + market + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	public Cups() {
		System.out.println("Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String[] args) {
		System.out.println("inside main");
		Cups.cup1.f(99);
	}
}
