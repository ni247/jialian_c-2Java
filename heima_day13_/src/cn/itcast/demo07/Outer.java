package cn.itcast.demo07;

public class Outer {
	int i = 1;

	public void showw() {
		System.out.println("外部类的showw");
	}

	public class Inner {
		int i = 2;

		public void show() {
			int i = 3;
			System.out.println(i);
			System.out.println(this.i);
			// 调用外部类的成员
			// 外部类名.this.成员
			System.out.println(Outer.this.i);
			Outer.this.showw();
		}
	}
}
