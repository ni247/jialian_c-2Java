package cn.itcast.demo09;

public class Test {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.openComputer();
		/*
		 * USB s = new Mouse(); com.useUSB(s); s = new HardDisk();
		 * com.useUSB(s);
		 */

		// 使用匿名对象
		com.useUSB(new Mouse());
		com.useUSB(new HardDisk());
		com.useUSB(new Keyboard());
	}
}
