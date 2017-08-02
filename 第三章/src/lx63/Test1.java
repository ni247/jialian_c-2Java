package lx63;

import org.junit.Test;

public class Test1 {
	@Test
	public void Run1() {
		int big = Integer.MAX_VALUE;
		System.out.println(big);
		System.out.println(big * big);
	}

	@Test
	public void Run2() {
		// 直接比较 a==3 false
		Equal2Str("3", "3");
		// 赋值比较也相同.
		String s1 = "3";
		String s2 = "3";
		Equal2Str(s1, s2);

		// 结论:比较字符串是否相等时使用equals
		// 字符串String 类重写了Object的equal方法
	}

	public void Equal2Str(String a, String b) {
		System.out.println("a==b:" + a == b);
		System.out.println("a!=b:" + a != b);
		System.out.println("a.equals:" + a.equals(b));
	}
}
