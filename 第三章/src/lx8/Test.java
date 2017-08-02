package lx8;

public class Test {
	public static void main(String[] args) {
		long a = 0x1234321;
		long b = 03213;
		String ra = Long.toBinaryString(a);  //long.toBinaryString 转换为二进制字符串
		String rb = Long.toBinaryString(b);
		System.out.println(ra);
		System.out.println(rb);
	}
}
