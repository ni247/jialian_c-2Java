package cn.itcast.demo09;

/*
 * 定义笔记本类
 * 功能:开机,关机,使用usb设备
 */
public class Computer {

	public void openComputer() {
		System.out.println("笔记本开机");
	}

	public void closeComputer() {
		System.out.println("笔记本关机");
	}

	// 使用usb设备
	// 方法的参数,是一个
	// 笔记本没有实现usb接口
	public void useUSB(USB usb) {
		usb.open();
		usb.close();
	}
}
