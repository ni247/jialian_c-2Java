package lx_97;

import org.junit.Test;

public class Run {
	static String s = "123";
	static String s1;
	static {
		s1 = "222";
	}

	static void say() {
		System.out.println(s);
		System.out.println(s1);
	}

	@Test
	public void lx13() {
		Run.say();
	}
}
