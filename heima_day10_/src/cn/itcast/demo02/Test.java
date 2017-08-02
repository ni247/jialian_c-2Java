package cn.itcast.demo02;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Zi z = new Zi();
		System.out.println(z.i);
		Fu f = new Fu();
		System.out.println(f.i);
		// 创建子类实例对象,但是赋给了父类变量
		Fu f1 = new Zi();
		System.out.println(f1.i);
		z.print();
	}
}
