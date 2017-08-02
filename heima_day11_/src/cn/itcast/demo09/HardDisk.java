package cn.itcast.demo09;

public class HardDisk implements USB {

	@Override
	public void open() {
		System.out.println("硬盘开启了");
	}

	@Override
	public void close() {
		System.out.println("硬盘关闭了");
	}

}
