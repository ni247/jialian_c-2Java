package cn.itcast.demo4;

/*
 *  开启输出和输入线程,实现赋值和打印值
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Resource r = new Resource();
		Input in = new Input(r);
		Output out = new Output(r);
		Thread tin = new Thread(in);
		Thread tout = new Thread(out);
		tin.start();
		tout.start();
	}
}
