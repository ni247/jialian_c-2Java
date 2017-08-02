package cn.itcast.demo09;

public class Mouse implements USB {

	@Override
	public void open() {
		System.out.println("鼠标插上去了");
	}

	@Override
	public void close() {
		System.out.println("鼠标拔出来了");
	}

}
