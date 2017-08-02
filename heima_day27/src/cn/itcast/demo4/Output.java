package cn.itcast.demo4;

/*
 * 输出资源,对资源对象resource中成员变量,输出值
 * 
 * wait notify 必须用锁调用
 */
public class Output implements Runnable {
	private Resource r;

	public Output(Resource r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			//这里因为两把锁不同
			synchronized (r) {
				if (!r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(r.name + r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}
