package cn.itcast.demo1;

/*
 *  String getName() 获取线程名字
 */
public class NameThread extends Thread {
	public void run() {
		System.out.println(super.getName());
	}

	public NameThread(String name) {
		super(name);
		super.setName(name);
	}

	public NameThread() {
		super();
	}
}
